package com.myapp.userapp.api;

import com.myapp.userapp.model.UserEntity;
import com.myapp.userapp.repository.UserEntityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/users/")
public class UserEntityController {

    @Autowired
    private UserEntityRepository userEntityRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @PostMapping
    public UserEntity saveUser(@RequestBody UserEntity userEntity) {
        String encryptedPassword = passwordEncoder.encode(userEntity.getPassword());
        userEntity.setPassword(encryptedPassword);
        userEntityRepository.save(userEntity);
        return userEntity;
    }
}
