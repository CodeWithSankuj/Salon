package com.salon.user.service.service.impl;

import com.salon.user.service.exception.UserException;
import com.salon.user.service.modal.User;
import com.salon.user.service.repository.UserRepository;
import com.salon.user.service.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {
    private final UserRepository _userRepository;

    @Override
    public User createUser(User user) {
        return _userRepository.save(user);
    }

    @Override
    public void deleteUser(Long id) throws Exception{
        Optional<User> user = _userRepository.findById(id);
        if(user.isEmpty()) throw new UserException("User Not found");
        _userRepository.delete(user.get());
    }

    @Override
    public User updateUser(Long id, User user) throws Exception{
        Optional<User> oldUser = _userRepository.findById(id);
        if(oldUser.isEmpty()){
            throw  new UserException("User not found");
        }
        User userEntity = oldUser.get();
        userEntity.setFullName(user.getFullName());
        userEntity.setPhone(user.getPhone());
        userEntity.setRole(user.getRole());
        _userRepository.save(userEntity);
        return userEntity;
    }

    @Override
    public User getUserById(Long id) throws Exception {
        Optional<User> user = _userRepository.findById(id);
        if(user.isPresent()){
            return user.get();
        }
        return null;
    }

    @Override
    public List<User> getAllUsers() {
        return _userRepository.findAll();
    }

    @Override
    public boolean existsUser(String userName, String email){
        Optional<User> userObj = _userRepository.findAll().stream().filter(x-> x.getFullName().equals(userName) || x.getEmail().equals(email)).findFirst();
        return userObj.isPresent();
    }
}
