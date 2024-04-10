package com.myapp.userapp.service;

import com.myapp.userapp.dto.UserDTO;
import com.myapp.userapp.model.User;
import com.myapp.userapp.repository.UserRepository;
import com.myapp.userapp.util.UserDtoUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements UserService{

    @Autowired
    private UserRepository userRepository;

    public void setUserRepository(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public UserDTO addUser(UserDTO userDTO) {
        User user = userRepository.addUser(UserDtoUtil.dtoToEntity(userDTO));
        return UserDtoUtil.entityToDto(user);
    }

    public UserDTO updateUser(int userId, UserDTO userDTO) {
        User user = userRepository.updateUser(userId, UserDtoUtil.dtoToEntity(userDTO));
        return UserDtoUtil.entityToDto(user);
    }

    public void deleteUser(int userId){
        userRepository.deleteUser(userId);
    }

    public UserDTO getUserById(int userId) {
        return userRepository.getUserById(userId)
                .map(UserDtoUtil::entityToDto)
                .orElseThrow();
    }

    public UserDTO getUserByName(String name) {
        return userRepository.getUserByName(name)
                .map(UserDtoUtil::entityToDto)
                .orElseThrow();
    }

    public List<UserDTO> getAllUsers() {
        return userRepository.getAllUsers()
                .stream()
                .map(UserDtoUtil::entityToDto)
                .toList();
    }


}
