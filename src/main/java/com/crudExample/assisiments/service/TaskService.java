package com.crudExample.assisiments.service;

import com.crudExample.assisiments.dto.TaskDTO;
import com.crudExample.assisiments.entity.Task;
import com.crudExample.assisiments.exception.TaskNotFoundException;
import com.crudExample.assisiments.repository.TaskRepository;
import com.crudExample.validation.TaskValidator;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@RequiredArgsConstructor
@Service
public class TaskService {
    private final TaskRepository taskRepository;
    private final TaskValidator taskValidator;
    private final ObjectMapper objectMapper;

    public TaskDTO createTask(TaskDTO taskDTO) {
        Task task = objectMapper.convertValue(taskDTO, Task.class);
        taskValidator.validate(task);
        Task savedTask = taskRepository.save(task);
        return objectMapper.convertValue(savedTask, TaskDTO.class);
    }

    public Page<Task> getTasks(int page, int size, String sortBy, String sortDirection) {
        Pageable pageable = PageRequest.of(page, size, Sort.by(Sort.Direction.fromString(sortDirection), sortBy));
        return taskRepository.findAll(pageable);
    }

    public TaskDTO getTaskById(Long id) {
        Task task = taskRepository.findById(id)
                .orElseThrow(() -> new TaskNotFoundException("Task not found with id " + id));
        return objectMapper.convertValue(task, TaskDTO.class);
    }

    public TaskDTO updateTask(Long id, TaskDTO taskDTO) {
        Task task = taskRepository.findById(id)
                .orElseThrow(() -> new TaskNotFoundException("Task not found with id " + id));

        task.setTitle(taskDTO.getTitle());
        task.setDescription(taskDTO.getDescription());
        task.setStatus(taskDTO.getStatus());

        taskValidator.validate(task);

        Task updatedTask = taskRepository.save(task);
        return objectMapper.convertValue(updatedTask, TaskDTO.class);
    }

    public void deleteTask(Long id) {
        taskRepository.deleteById(id);
    }

    public List<TaskDTO> getAllTasks() {
        List<Task> tasks = taskRepository.findAll();
        return tasks.stream()
                .map(task -> objectMapper.convertValue(task, TaskDTO.class))
                .collect(Collectors.toList());
    }
}
