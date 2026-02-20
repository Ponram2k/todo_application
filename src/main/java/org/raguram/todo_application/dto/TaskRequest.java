package org.raguram.todo_application.dto;

import org.raguram.todo_application.model.Status;

public record TaskRequest(String title, String description, Status status) {
}
