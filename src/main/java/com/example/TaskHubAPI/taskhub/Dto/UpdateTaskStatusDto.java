package com.example.TaskHubAPI.taskhub.Dto;

import com.example.TaskHubAPI.taskhub.Enum.Status;
import jakarta.validation.constraints.NotNull;

public class UpdateTaskStatusDto {

    @NotNull
    private Status status;

    // Getter and Setter
    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }
}
