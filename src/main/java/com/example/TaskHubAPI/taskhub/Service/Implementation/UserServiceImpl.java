package com.example.TaskHubAPI.taskhub.Service.Implementation;

import com.example.TaskHubAPI.taskhub.Dto.CreateUserDto;
import com.example.TaskHubAPI.taskhub.Dto.UserResponseDto;
import com.example.TaskHubAPI.taskhub.Entity.User;
import com.example.TaskHubAPI.taskhub.Service.Interface.UserService;
import com.example.TaskHubAPI.taskhub.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.stream.Collectors;

@Service
    public class UserServiceImpl implements UserService {

        @Autowired
        private UserRepository userRepository;

        @Override
        public UserResponseDto createUser(CreateUserDto dto) {
            User user = new User();
            user.setName(dto.getName());
            user.setEmail(dto.getEmail());

            User saved = userRepository.save(user);
            return mapToDto(saved);
        }

        @Override
        public List<UserResponseDto> getAllUsers() {
            return userRepository.findAll().stream()
                    .map(this::mapToDto)
                    .collect(Collectors.toList());
        }

        @Override
        public UserResponseDto getUserById(Long id) {
            return userRepository.findById(id)
                    .map(this::mapToDto)
                    .orElseThrow(() -> new RuntimeException("User not found"));
        }

        @Override
        public UserResponseDto updateUser(Long id, CreateUserDto dto) {
            User user = userRepository.findById(id)
                    .orElseThrow(() -> new RuntimeException("User not found"));

            user.setName(dto.getName());
            user.setEmail(dto.getEmail());

            return mapToDto(userRepository.save(user));
        }

        @Override
        public void deleteUser(Long id) {
            userRepository.deleteById(id);
        }

        private UserResponseDto mapToDto(User user) {
            UserResponseDto dto = new UserResponseDto();
            dto.setId(user.getId());
            dto.setName(user.getName());
            dto.setEmail(user.getEmail());
            return dto;
        }
    }
