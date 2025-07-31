package com.example.TaskHubAPI.taskhub.Dto;

import com.example.TaskHubAPI.taskhub.Enum.Priority;
import com.example.TaskHubAPI.taskhub.Enum.Status;
import jakarta.validation.constraints.Future;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
@Getter
@Setter
public class CreateTaskDto  {
    @NotBlank
     private String title;

     private String description;
     @NotNull
     private Status status;
     @NotNull
     private Priority priority;
 @Future(message = "Due date must be in the future")
 @NotNull
 private LocalDate dueDate;
     @NotNull
     private Long userId;

}
