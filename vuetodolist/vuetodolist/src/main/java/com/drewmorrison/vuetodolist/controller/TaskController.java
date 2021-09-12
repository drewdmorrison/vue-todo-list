package com.drewmorrison.vuetodolist.controller;

import com.drewmorrison.vuetodolist.dao.TaskDao;
import com.drewmorrison.vuetodolist.model.Task;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@CrossOrigin
public class TaskController {

    @Autowired
    private TaskDao taskDao;

    @RequestMapping(path="/alltasks", method = RequestMethod.GET)
    public List<Task> getAllTasks() {
        return taskDao.getAllTasks();
    }
}
