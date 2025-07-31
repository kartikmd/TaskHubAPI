package com.example.TaskHubAPI.taskhub.repository;

import com.example.TaskHubAPI.taskhub.Entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User,Long> {

}
