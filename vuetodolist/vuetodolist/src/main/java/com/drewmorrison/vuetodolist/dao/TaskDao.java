package com.drewmorrison.vuetodolist.dao;

import com.drewmorrison.vuetodolist.model.Task;

import java.util.Date;
import java.util.List;

public interface TaskDao {

    int getTasksLeft();
    List<Task> getAllTasks();
    Task getTaskById();
    String addTask(String taskName, String taskDescription, Date dueDate);
    String updateTask(Task task, int taskStatusId);
    int addToTasksRemaining();
    int removeFromTasksRemaining();
}
