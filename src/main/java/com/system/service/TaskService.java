package com.system.service;

import com.system.entity.Task;
import com.system.entity.User;
import java.util.List;

public interface TaskService {
    void addTaskToUser(Task task, User user);
    List<Task> findTasksByUser(User user);
}
