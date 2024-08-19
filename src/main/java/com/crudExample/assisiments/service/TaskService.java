package com.crudExample.assisiments.service;

import com.crudExample.assisiments.entity.Task;
import com.crudExample.assisiments.exception.TaskNotFoundException;
import com.crudExample.assisiments.repository.TaskRepository;
import com.crudExample.validation.TaskValidator;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

@Slf4j
@RequiredArgsConstructor
@Service
public class TaskService {
    private final TaskRepository taskRepository;
    private final TaskValidator taskValidator;


    public Task createTask(Task task) {

        taskValidator.validate(task);
log.info("ALl Validation{}",taskValidator);

        return taskRepository.save(task);
    }

    public List<Task> getAllTasks() {

        return taskRepository.findAll();
    }
    public Page<Task> getTasks(int page, int size, String sortBy, String sortDirection) {
        Pageable pageable = PageRequest.of(page, size, Sort.by(Sort.Direction.fromString(sortDirection), sortBy));
        log.info("Pageable {}",pageable);
        return taskRepository.findAll(pageable);
    }
    public Task getTaskById(Long id) {
        return taskRepository.findById(id).orElseThrow(() -> new TaskNotFoundException("Task not found with id " + id));
    }
    public Task updateTask(Long id, Task task) {
//        TaskValidator validator = new TaskValidator(taskRepository);
//        validator.validate(task);
        taskValidator.validate(task);
        task.setId(id);
        return taskRepository.save(task);
    }

    public void deleteTask(Long id) {
        taskRepository.deleteById(id);
    }
}