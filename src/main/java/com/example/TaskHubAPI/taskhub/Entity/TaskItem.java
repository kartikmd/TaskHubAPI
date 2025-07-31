package com.example.TaskHubAPI.taskhub.Entity;

import jakarta.persistence.*;
import com.example.TaskHubAPI.taskhub.Enum.Status;
import lombok.Getter;
import lombok.Setter;
import com.example.TaskHubAPI.taskhub.Enum.Priority;

import java.time.LocalDate;
@Getter
@Setter
@Entity
public class TaskItem
{
    @Id @GeneratedValue
    private long id;
    private  String title;
    private  String description;

@Enumerated(EnumType.STRING)
    private Status status;

    @Enumerated(EnumType.STRING)
    private Priority priority;

    private LocalDate dueDate;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;
}
