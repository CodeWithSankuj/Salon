package com.salon.user.service.controller;

import com.salon.user.service.modal.User;
import com.salon.user.service.service.UserService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/user")
@RequiredArgsConstructor
public class UserController {
    private final UserService _userService;

    @PostMapping
    public ResponseEntity<?> createUser(@RequestBody @Valid User user){
        try {
            boolean userExist = _userService.existsUser(user.getUsername(), user.getEmail());
            if (userExist) return new ResponseEntity<>("User already exists", HttpStatus.BAD_REQUEST);
            return new ResponseEntity<>(_userService.createUser(user), HttpStatus.CREATED);
        }
        catch (Exception e){
            return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    @GetMapping
    public ResponseEntity<?> GetUser(){
        try {
            return new ResponseEntity<>(_userService.getAllUsers(), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> GetById(@PathVariable Long id) throws Exception{
        try {
            var user = _userService.getUserById(id);
            if(user==null) return new ResponseEntity<>("User not found", HttpStatus.NOT_FOUND);
            return new ResponseEntity<>(user, HttpStatus.OK);
        }
        catch (Exception e){
            return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping("/{id}")
    public ResponseEntity<?> UpdateUser(@RequestBody User user, @PathVariable Long id) throws Exception {
        try {
            var currUser = _userService.getUserById(id);
            if(currUser==null) return new ResponseEntity<>("User not found", HttpStatus.NOT_FOUND);
            return new ResponseEntity<>(_userService.updateUser(id, user), HttpStatus.OK);
        }
        catch (Exception e){
            return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteUser(@PathVariable Long id) throws Exception {
        try {
            var currUser = _userService.getUserById(id);
            if(currUser==null) return new ResponseEntity<>("User not found", HttpStatus.NOT_FOUND);
            _userService.deleteUser(id);
            return new ResponseEntity<>("Deleted Successfully", HttpStatus.ACCEPTED);
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
