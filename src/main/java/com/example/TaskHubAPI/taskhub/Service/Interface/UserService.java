package com.example.TaskHubAPI.taskhub.Service.Interface;

import com.example.TaskHubAPI.taskhub.Dto.CreateUserDto;
import com.example.TaskHubAPI.taskhub.Dto.UserResponseDto;

import java.util.List;

public interface UserService {
    UserResponseDto createUser(CreateUserDto dto);
    List<UserResponseDto> getAllUsers();
    UserResponseDto getUserById(Long id);
    UserResponseDto updateUser(Long id, CreateUserDto dto);
    void deleteUser(Long id);
}
