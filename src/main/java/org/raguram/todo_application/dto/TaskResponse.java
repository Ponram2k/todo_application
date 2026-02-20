package org.raguram.todo_application.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.raguram.todo_application.model.Status;

import java.time.LocalDateTime;

@Getter
@Setter
@ToString
@Builder
public class TaskResponse {

    private Long taskId;

    private String title;

    private String description;

    private Status status;

    private LocalDateTime createdAt;

    private LocalDateTime modifiedAt;
}
