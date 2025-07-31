package com.example.TaskHubAPI.taskhub.repository;

import com.example.TaskHubAPI.taskhub.Entity.TaskItem;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TaskRepository extends JpaRepository<TaskItem,Long> {
    List<TaskItem> findByUserId(Long userId);

}
