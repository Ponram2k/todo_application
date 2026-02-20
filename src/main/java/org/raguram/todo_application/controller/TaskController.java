package org.raguram.todo_application.controller;

import org.raguram.todo_application.entity.Task;
import org.raguram.todo_application.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/task")
public class TaskController {

    private final TaskService taskService;

    @Autowired
    public TaskController(TaskService taskService){
        this.taskService = taskService;
    }

    @PostMapping("/save/{user_id}")
    public ResponseEntity<String> saveTask(@RequestBody Task task, @PathVariable("user_id") Long userId){
        taskService.saveTask(userId,task);
        return ResponseEntity.status(HttpStatus.CREATED).body("Task Created");
    }
}
