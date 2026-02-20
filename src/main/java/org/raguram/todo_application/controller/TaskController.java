package org.raguram.todo_application.controller;

import org.raguram.todo_application.dto.TaskRequest;
import org.raguram.todo_application.model.Task;
import org.raguram.todo_application.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/user")
public class TaskController {

    private final TaskService taskService;

    @Autowired
    public TaskController(TaskService taskService){
        this.taskService = taskService;
    }

    @PostMapping("/{user_id}/task")
    public ResponseEntity<Task> saveTask(@RequestBody TaskRequest task, @PathVariable("user_id") long userId){
        return ResponseEntity.status(HttpStatus.CREATED).body(taskService.saveTask(userId,task));
    }

    @GetMapping("/{user_id}/task")
    public ResponseEntity<List<Task>> fetchAllTask(@PathVariable("user_id") long userId){
        return ResponseEntity.ok(taskService.fetchAllTask(userId));
    }
}
