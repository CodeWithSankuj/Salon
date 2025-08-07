package com.salon.user.service.service;

import com.salon.user.service.modal.User;

import java.util.List;

public interface UserService {
    User createUser(User user);
    void deleteUser(Long id) throws Exception;
    User updateUser(Long id, User user) throws Exception;
    User getUserById(Long id) throws  Exception;
    List<User> getAllUsers();
    boolean existsUser(String userName, String email);

}
