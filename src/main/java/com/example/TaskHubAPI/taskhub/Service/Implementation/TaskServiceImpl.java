package com.example.TaskHubAPI.taskhub.Service.Implementation;

import com.example.TaskHubAPI.taskhub.Enum.Status;
import com.example.TaskHubAPI.taskhub.Entity.User;
import com.example.TaskHubAPI.taskhub.Dto.CreateTaskDto;
import com.example.TaskHubAPI.taskhub.Dto.TaskResponseDto;
import com.example.TaskHubAPI.taskhub.Entity.TaskItem;
import com.example.TaskHubAPI.taskhub.Service.Interface.TaskService;
import com.example.TaskHubAPI.taskhub.repository.TaskRepository;
import com.example.TaskHubAPI.taskhub.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class TaskServiceImpl implements TaskService {

    @Autowired
    private TaskRepository taskRepository;

    @Autowired
    private UserRepository userRepository;

    @Override
    public TaskResponseDto createTask(CreateTaskDto dto) {
        User user = userRepository.findById(dto.getUserId())
                .orElseThrow(() -> new RuntimeException("User not found"));

        TaskItem task = new TaskItem();
        task.setTitle(dto.getTitle());
        task.setDescription(dto.getDescription());
        task.setStatus(dto.getStatus());
        task.setPriority(dto.getPriority());
        task.setDueDate(dto.getDueDate());
        task.setUser(user);

        return mapToDto(taskRepository.save(task));
    }

    @Override
    public List<TaskResponseDto> getAllTasks() {
        return taskRepository.findAll().stream()
                .map(this::mapToDto)
                .collect(Collectors.toList());
    }

    @Override
    public TaskResponseDto getTaskById(Long id) {
        return taskRepository.findById(id)
                .map(this::mapToDto)
                .orElseThrow(() -> new RuntimeException("Task not found"));
    }

    @Override
    public TaskResponseDto updateTask(Long id, CreateTaskDto dto) {
        TaskItem task = taskRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Task not found"));

        task.setTitle(dto.getTitle());
        task.setDescription(dto.getDescription());
        task.setStatus(dto.getStatus());
        task.setPriority(dto.getPriority());
        task.setDueDate(dto.getDueDate());

        User user = userRepository.findById(dto.getUserId())
                .orElseThrow(() -> new RuntimeException("User not found"));
        task.setUser(user);

        return mapToDto(taskRepository.save(task));
    }

    @Override
    public void deleteTask(Long id) {
        taskRepository.deleteById(id);
    }

    @Override
    public void updateTaskStatus(Long id, Status status) {
        TaskItem task = taskRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Task not found"));
        task.setStatus(status);
        taskRepository.save(task);
    }

    @Override
    public List<TaskResponseDto> getTasksByUserId(Long userId) {
        return taskRepository.findByUserId(userId).stream()
                .map(this::mapToDto)
                .collect(Collectors.toList());
    }

    private TaskResponseDto mapToDto(TaskItem task) {
        TaskResponseDto dto = new TaskResponseDto();
        dto.setId(task.getId());
        dto.setTitle(task.getTitle());
        dto.setDescription(task.getDescription());
        dto.setStatus(task.getStatus());
        dto.setPriority(task.getPriority());
        dto.setDueDate(task.getDueDate());
        dto.setUserId(task.getUser().getId());
        return dto;
    }
}
