package com.myapp.userapp.api;

import com.myapp.userapp.dto.UserDTO;
import com.myapp.userapp.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/users")
public class UserRestController {

    @Autowired
    private UserService userService;

    @PostMapping
    public ResponseEntity<UserDTO> saveUser(@RequestBody UserDTO user) {
    // TODO: write code to save user
        UserDTO newUser = userService.addUser(user);
        return ResponseEntity.status(HttpStatus.CREATED).body(user);
    }

    @GetMapping("/{id}")
    public UserDTO getUserById(@PathVariable("id") int userId) {
        // TODO:
        return null;
    }

    @GetMapping
    public List<UserDTO> getAllUsers() {
        return userService.getAllUsers();
    }

    @PutMapping("/{id}")
    public UserDTO updateUser(@PathVariable("id") int userId, @RequestBody UserDTO user) {
        return null;
    }

    @DeleteMapping("/{id}")
    public void deleteUser(@PathVariable("id") int userId) {
        userService.deleteUser(userId);
    }
}
