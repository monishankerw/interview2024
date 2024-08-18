package com.crudExample.assisiments.service;

import com.crudExample.assisiments.entity.Task;
import com.crudExample.assisiments.repository.TaskRepository;
import com.crudExample.validation.TaskValidator;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;


@RequiredArgsConstructor
@Service
public class TaskService {
    private final TaskRepository taskRepository;
    private final TaskValidator taskValidator;


    public Task createTask(Task task) {

        taskValidator.validate(task);


        return taskRepository.save(task);
    }
}