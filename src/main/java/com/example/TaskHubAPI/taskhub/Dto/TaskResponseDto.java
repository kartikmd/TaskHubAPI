package com.example.TaskHubAPI.taskhub.Dto;

import com.example.TaskHubAPI.taskhub.Enum.Priority;
import com.example.TaskHubAPI.taskhub.Enum.Status;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
@Getter
@Setter
public class TaskResponseDto {
    private Long id;
    private String title;
    private String description;
    private Status status;
    private Priority priority;
    private LocalDate dueDate;
    private Long userId;

}
