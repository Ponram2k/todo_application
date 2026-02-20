package org.raguram.todo_application.service;

import org.raguram.todo_application.dao.TaskRepository;
import org.raguram.todo_application.entity.Task;
import org.raguram.todo_application.entity.User;
import org.springframework.stereotype.Service;

@Service
public class TaskService {

    private final TaskRepository taskRepository;

    public TaskService(TaskRepository taskRepository){
        this.taskRepository = taskRepository;
    }

    public void saveTask(Long userId, Task task){
        User user = User.builder().id(userId).build();
        task.setUserData(user);
        taskRepository.save(task);
    }

}
