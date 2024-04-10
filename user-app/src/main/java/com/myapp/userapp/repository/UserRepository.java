package com.myapp.userapp.repository;

import com.myapp.userapp.dto.UserDTO;
import com.myapp.userapp.model.User;
import com.myapp.userapp.util.UserDtoUtil;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public interface UserRepository {
    public User addUser(User user);

    public List<User> getAllUsers();

    public User updateUser(int userId, User user);

    public void deleteUser(int userId);

    public Optional<User> getUserById(int userId);

    public Optional<User> getUserByName(String name);
}
