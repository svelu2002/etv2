package com.myapp.userapp.util;

import com.myapp.userapp.dto.UserDTO;
import com.myapp.userapp.model.User;

public class UserDtoUtil {


        public static UserDTO entityToDto(User user) {
                return new UserDTO(user.getUserId(), user.getName(), user.getEmail(), user.getDob());
        }

        public static User dtoToEntity(UserDTO userDTO) {
                return new User(userDTO.userId(), userDTO.name(), userDTO.email(), userDTO.dob());
        }
    


}
