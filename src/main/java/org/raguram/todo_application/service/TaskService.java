package org.raguram.todo_application.service;

import org.raguram.todo_application.dao.TaskRepository;
import org.raguram.todo_application.dao.UserRepository;
import org.raguram.todo_application.dto.TaskRequest;
import org.raguram.todo_application.model.Status;
import org.raguram.todo_application.model.Task;
import org.raguram.todo_application.model.User;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class TaskService {

    private final TaskRepository taskRepository;

    private final UserRepository userRepository;

    public TaskService(TaskRepository taskRepository,UserRepository userRepository){
        this.taskRepository = taskRepository;
        this.userRepository = userRepository;
    }

    public Task saveTask(Long userId, TaskRequest taskRequest){
        User user = userRepository.findById(userId).orElseThrow(()->new RuntimeException("User not found"));

        Task task = Task.builder()
                .title(taskRequest.title())
                .status(Status.PENDING)
                .createdAt(LocalDateTime.now())
                .modifiedAt(LocalDateTime.now())
                .userData(user)
                .build();
        return  taskRepository.save(task);
    }

    public List<Task> fetchAllTask(long userId) {
        return taskRepository.findAllByUserId(userId);
    }

}
