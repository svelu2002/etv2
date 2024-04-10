package com.myapp.userapp.service;

import com.myapp.userapp.dto.UserDTO;
import com.myapp.userapp.model.User;
import com.myapp.userapp.repository.UserRepository;
import com.myapp.userapp.util.UserDtoUtil;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDate;
import java.util.NoSuchElementException;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(MockitoExtension.class)
public class UserServiceImplTest {

    @Mock
    UserRepository repository;
    @InjectMocks
    UserServiceImpl service;


    @Test
    public void testGetByUserId() {
        // Given
        int userId = 1;

        var user = new User(1, "abc", "abc.yahoo.com",  LocalDate.of(2000, 10, 18));

        // When
        Mockito.when(repository.getUserById(userId)).thenReturn(Optional.of(user));
        Assertions.assertEquals(UserDtoUtil.entityToDto(user), service.getUserById(userId));

        // Then
        Mockito.verify(repository, Mockito.times(1)).getUserById(userId);
    }

    @Test
    public void testAddUser() {
        // Given
        LocalDate dob = LocalDate.of(2020, 10, 10);
        User user = new User(2, "velayutham", "velayutham@example.com", dob);
        UserDTO userDTO = UserDtoUtil.entityToDto(user);

        // When
        Mockito.when(repository.addUser(user)).thenReturn(user);
        Assertions.assertEquals(userDTO, service.addUser(userDTO));

        // Then
        Mockito.verify(repository, Mockito.times(1)).addUser(user);
    }

    @Test
    public void testDeleteUser() {
        // Given
        int userId = 1;

        var user = new User(1, "abc", "abc.yahoo.com",  LocalDate.of(2000, 10, 18));

        // When
        Mockito.doNothing().when(repository).deleteUser(userId);
        Mockito.doThrow(new NoSuchElementException("User ID not available")).when(repository).deleteUser(2);

        Assertions.assertDoesNotThrow(() -> service.deleteUser(userId));
        Assertions.assertThrows(NoSuchElementException.class, ()-> service.deleteUser(2));
        // Then
        Mockito.verify(repository, Mockito.times(1)).deleteUser(userId);
        Mockito.verify(repository, Mockito.times(1)).deleteUser(2);
    }
}
