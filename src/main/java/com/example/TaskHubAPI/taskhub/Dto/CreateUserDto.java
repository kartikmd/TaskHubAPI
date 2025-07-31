package com.example.TaskHubAPI.taskhub.Dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter

public class CreateUserDto {
    @NotBlank
    private String name;

    @Email
    private String email;
    }


