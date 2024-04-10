package com.myapp.userapp.repository;

import com.myapp.userapp.dto.UserDTO;
import com.myapp.userapp.model.User;
import com.myapp.userapp.util.UserDtoUtil;
import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Repository;

import java.util.*;

@Repository
public class UserRepositoryImpl implements UserRepository {
    private Map<Integer, User> users;

    @PostConstruct
    public void init() {
        users = new HashMap<>();
    }

    @Override
    public User addUser(User user) {
        // add user to the database (here the map)
        users.put(user.getUserId(), user);
        return user;
    }

    @Override
    public List<User> getAllUsers() {
        return new ArrayList<User>(users.values());
    }

    @Override
    public void deleteUser(int userId) {
        getUserById(userId).orElseThrow();
        users.remove(userId);
    }

    public User updateUser(int userId, User user) {
        getUserById(userId).orElseThrow();
        users.put(userId, user);
        return users.get(userId);
    }

    public Optional<User> getUserById(int userId) {
        User user = users.get(userId);
        return user != null ? Optional.of(user) : Optional.empty();
    }

    public Optional<User> getUserByName(String name) {
        return users.values()
                .stream()
                .filter(user -> user.getName().equalsIgnoreCase(name))
                .findFirst();
    }
}
