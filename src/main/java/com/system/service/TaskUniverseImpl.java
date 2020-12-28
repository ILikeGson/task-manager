package com.system.service;

import com.system.entity.Task;
import com.system.entity.User;
import com.system.repository.TaskRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class TaskUniverseImpl implements TaskService {
    private final TaskRepository taskRepository;

    public TaskUniverseImpl(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }

    @Override
    public void addTaskToUser(Task task, User user) {
        task.setUser(user);
        taskRepository.save(task);
    }

    @Override
    @Transactional(readOnly = true)
    public List<Task> findTasksByUser(User user) {
        return taskRepository.findTasksByUser(user);
    }
}
