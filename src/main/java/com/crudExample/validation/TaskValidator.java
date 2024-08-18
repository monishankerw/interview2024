package com.crudExample.validation;

import com.crudExample.assisiments.Status;
import com.crudExample.assisiments.exception.DuplicateTaskException;
import com.crudExample.assisiments.exception.ValidationException;
import com.crudExample.assisiments.entity.Task;
import com.crudExample.assisiments.repository.TaskRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@RequiredArgsConstructor
@Component
public class TaskValidator {

    private final TaskRepository taskRepository;

    public void validate(Task task) {
        validateTitle(task.getTitle());
        validateDescription(task.getDescription());
        validateStatus(task.getStatus());
        validateCreatedDate(task.getCreatedDate());
        checkForDuplicates(task);
    }

    private void validateTitle(String title) {
        if (title == null || title.isEmpty()) {
            throw new ValidationException("Task title cannot be empty");
        }
    }

    private void validateDescription(String description) {
        if (description == null || description.isEmpty()) {
            throw new ValidationException("Task description cannot be empty");
        }
        if (description.length() > 500) {
            throw new ValidationException("Task description cannot exceed 500 characters");
        }
    }

    private void validateStatus(Status status) {
        if (status == null) {
            throw new ValidationException("Task status cannot be null");
        }
    }

    private void validateCreatedDate(LocalDateTime createdDate) {
        if (createdDate != null && createdDate.isAfter(LocalDateTime.now())) {
            throw new ValidationException("Task created date cannot be in the future");
        }
    }

    private void checkForDuplicates(Task task) {
        if (taskRepository.existsByTitle(task.getTitle())) {
            throw new DuplicateTaskException("Task with this title already exists");
        }
        if (taskRepository.existsByDescription(task.getDescription())) {
            throw new DuplicateTaskException("Task with this description already exists");
        }
    }
}
