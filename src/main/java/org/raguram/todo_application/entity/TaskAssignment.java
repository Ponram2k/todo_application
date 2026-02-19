package org.raguram.todo_application.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

//@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class TaskAssignment {

//    @Id
//    @GeneratedValue(
//            strategy = GenerationType.SEQUENCE,
//            generator = "task_ass_seq_gen"
//    )
//    @SequenceGenerator(
//            name="task_ass_seq_gen",
//            sequenceName = "task_assign_seq",
//            allocationSize = 1
//    )
    private int id;

//    @Column
    private int userId;

//    @Column
    private int taskId;
}
