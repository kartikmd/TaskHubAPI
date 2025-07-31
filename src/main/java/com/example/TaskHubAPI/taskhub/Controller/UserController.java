package com.example.TaskHubAPI.taskhub.Controller;

import com.example.TaskHubAPI.taskhub.Dto.CreateUserDto;
import com.example.TaskHubAPI.taskhub.Dto.UserResponseDto;
import com.example.TaskHubAPI.taskhub.Service.Interface.UserService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/users")
public class UserController {
    @Autowired
    private UserService userService;

    // 🔹 Create new user
    @PostMapping
    public ResponseEntity<UserResponseDto> createUser(@Valid @RequestBody CreateUserDto dto) {
        UserResponseDto created = userService.createUser(dto);
        return ResponseEntity.ok(created);
    }

    // 🔹 Get all users
    @GetMapping
    public ResponseEntity<List<UserResponseDto>> getAllUsers() {
        return ResponseEntity.ok(userService.getAllUsers());
    }

    // 🔹 Get user by ID
    @GetMapping("/{id}")
    public ResponseEntity<UserResponseDto> getUserById(@PathVariable Long id) {
        return ResponseEntity.ok(userService.getUserById(id));
    }

    // 🔹 Update user
    @PutMapping("/{id}")
    public ResponseEntity<UserResponseDto> updateUser(
            @PathVariable Long id,
            @Valid @RequestBody CreateUserDto dto) {
        return ResponseEntity.ok(userService.updateUser(id, dto));
    }

    // 🔹 Delete user
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteUser(@PathVariable Long id) {
        userService.deleteUser(id);
        return ResponseEntity.noContent().build();
    }
}

