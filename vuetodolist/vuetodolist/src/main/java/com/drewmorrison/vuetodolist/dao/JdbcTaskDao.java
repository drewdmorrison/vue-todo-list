package com.drewmorrison.vuetodolist.dao;

import com.drewmorrison.vuetodolist.model.Task;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Component;
import org.springframework.jdbc.core.JdbcTemplate;


import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Component
public class JdbcTaskDao implements TaskDao {

    @Autowired
    private JdbcTemplate jdbcTemplate;
    @Autowired
    private TaskDao taskDao;

    @Override
    public int getTasksLeft() {
        return 0;
    }

    @Override
    public List<Task> getAllTasks() {
        List<Task> tasks = new ArrayList<>();

        String sql = "SELECT * FROM tasks;";
        SqlRowSet results = jdbcTemplate.queryForRowSet(sql);
        while (results.next()) {
            Task task = mapRowToTask(results);
            tasks.add(task);
        }

        return tasks;
    }

    @Override
    public Task getTaskById() {
        return null;
    }

    @Override
    public String addTask(String taskName, String taskDescription, Date dueDate) {
        return null;
    }

    @Override
    public String updateTask(Task task, int taskStatusId) {
        return null;
    }

    @Override
    public int addToTasksRemaining() {
        return 0;
    }

    @Override
    public int removeFromTasksRemaining() {
        return 0;
    }

    public Task mapRowToTask(SqlRowSet results) {
        Task task = new Task();
        task.setTaskId(results.getInt("task_id"));
        task.setTaskName(results.getString("task_name"));
        task.setTaskDescription(results.getString("task_desc"));
        task.setDueDate(results.getDate("due_date"));
        task.setTaskStatusId(results.getInt("task_status_id"));

        try {
            task.setTaskStatusDesc(results.getString("task_status_desc"));
        } catch (Exception ex) {}

        return task;
    }
}
