package org.raguram.todo_application.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Task {

    @Id
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "task_seq_gen"
    )
    @SequenceGenerator(
            name = "task_seq_gen",
            sequenceName = "task_sequence",
            allocationSize = 1
    )
    private long id;

    @Column
    private String title;

    @Column
    private String description;

    @Column
    private Status status;

    @Column
    private LocalDateTime createdAt;

    @Column
    private LocalDateTime modifiedAt;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private User userData;
}
