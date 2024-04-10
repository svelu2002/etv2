package com.myapp.userapp.service;

import com.myapp.userapp.dto.UserDTO;
import com.myapp.userapp.model.User;
import com.myapp.userapp.util.UserDtoUtil;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public interface UserService {
    public UserDTO addUser(UserDTO userDTO);

    public List<UserDTO> getAllUsers();

    public UserDTO updateUser(int userId, UserDTO user);

    public void deleteUser(int userId);

    public UserDTO getUserById(int userId);

    public UserDTO getUserByName(String name);
}
