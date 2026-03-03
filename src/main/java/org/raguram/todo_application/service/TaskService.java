package org.raguram.todo_application.service;

import org.raguram.todo_application.dao.TaskRepository;
import org.raguram.todo_application.dao.UserRepository;
import org.raguram.todo_application.dto.TaskRequest;
import org.raguram.todo_application.dto.TaskResponse;
import org.raguram.todo_application.model.Status;
import org.raguram.todo_application.model.Task;
import org.raguram.todo_application.model.UserDetail;
import org.raguram.todo_application.specification.TaskSpecification;
import org.springframework.data.jpa.domain.Specification;
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

    public TaskResponse saveTask(Long userId, TaskRequest taskRequest){
        UserDetail user = userRepository.findById(userId).orElseThrow(()->new RuntimeException("User not found"));

        Task task = Task.builder()
                .title(taskRequest.title())
                .description(taskRequest.description())
                .status(Status.PENDING)
                .createdAt(LocalDateTime.now())
                .modifiedAt(LocalDateTime.now())
                .userData(user)
                .build();
        Task savedTask = taskRepository.save(task);

        return mapToResponse(savedTask);
    }

    public List<TaskResponse> fetchAllTask(long userId, Status status, String taskName) {
        /* Initially  return the task
        return taskRepository.findAllByUserId(userId)
                .stream()
                .map(this::mapToResponse)
                .toList();*/

        Specification<Task> taskFilter = TaskSpecification.build(userId, status, taskName);
        return taskRepository.findAll(taskFilter)
                .stream()
                .map(this::mapToResponse)
                .toList();
    }

    private TaskResponse mapToResponse(Task task){
        return TaskResponse.builder()
                .taskId(task.getId())
                .title(task.getTitle())
                .description(task.getDescription())
                .status(task.getStatus())
                .createdAt(task.getCreatedAt())
                .modifiedAt(task.getModifiedAt())
                .build();
    }
}
