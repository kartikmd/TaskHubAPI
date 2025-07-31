package com.example.TaskHubAPI.taskhub.Service.Interface;

import com.example.TaskHubAPI.taskhub.Dto.CreateTaskDto;
import com.example.TaskHubAPI.taskhub.Dto.TaskResponseDto;
import com.example.TaskHubAPI.taskhub.Enum.Status;

import java.util.List;

public interface TaskService {
    TaskResponseDto createTask(CreateTaskDto dto);
    List<TaskResponseDto> getAllTasks();
    TaskResponseDto getTaskById(Long id);
    TaskResponseDto updateTask(Long id, CreateTaskDto dto);
    void deleteTask(Long id);
    void updateTaskStatus(Long id, Status status);
    List<TaskResponseDto> getTasksByUserId(Long userId);
}
