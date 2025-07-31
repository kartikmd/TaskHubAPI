package com.example.TaskHubAPI.taskhub.Controller;

import com.example.TaskHubAPI.taskhub.Dto.CreateTaskDto;
import com.example.TaskHubAPI.taskhub.Dto.TaskResponseDto;
import com.example.TaskHubAPI.taskhub.Service.Interface.TaskService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.example.TaskHubAPI.taskhub.Dto.UpdateTaskStatusDto;

import java.util.List;

@RestController
    @RequestMapping("/api/tasks")
    public class TaskController {

        @Autowired
        private TaskService taskService;

        // 🔹 Create new task
        @PostMapping
        public ResponseEntity<TaskResponseDto> createTask(@Valid @RequestBody CreateTaskDto dto) {
            return ResponseEntity.ok(taskService.createTask(dto));
        }

        // 🔹 Get all tasks
        @GetMapping
        public ResponseEntity<List<TaskResponseDto>> getAllTasks() {
            return ResponseEntity.ok(taskService.getAllTasks());
        }

        // 🔹 Get task by ID
        @GetMapping("/{id}")
        public ResponseEntity<TaskResponseDto> getTaskById(@PathVariable Long id) {
            return ResponseEntity.ok(taskService.getTaskById(id));
        }

        // 🔹 Update task
        @PutMapping("/{id}")
        public ResponseEntity<TaskResponseDto> updateTask(
                @PathVariable Long id,
                @Valid @RequestBody CreateTaskDto dto) {
            return ResponseEntity.ok(taskService.updateTask(id, dto));
        }

        // 🔹 Delete task
        @DeleteMapping("/{id}")
        public ResponseEntity<Void> deleteTask(@PathVariable Long id) {
            taskService.deleteTask(id);
            return ResponseEntity.noContent().build();
        }

        // 🔹 Update only status (PATCH)
        @PatchMapping("/{id}/status")
        public ResponseEntity<Void> updateStatus(
                @PathVariable Long id,
                @Valid @RequestBody UpdateTaskStatusDto dto) {
            taskService.updateTaskStatus(id, dto.getStatus());
            return ResponseEntity.ok().build();
        }

        // 🔹 Get tasks by user ID
        @GetMapping("/user/{userId}")
        public ResponseEntity<List<TaskResponseDto>> getTasksByUser(@PathVariable Long userId) {
            return ResponseEntity.ok(taskService.getTasksByUserId(userId));
        }
    }

