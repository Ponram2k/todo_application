package org.raguram.todo_application.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class User {

    @Id
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "user_seq_gen")
    @SequenceGenerator(
            name = "user_seq_gen",
            sequenceName = "user_sequence",
            allocationSize = 1
    )
    private long id;

    @Column(unique = true,nullable = false,length = 20)
    private String name;

    @Column(nullable = false)
    private long phoneNumber;

    @Column(nullable = false, length = 50)
    private String emailId;

    @OneToMany(mappedBy = "userData",cascade = CascadeType.REMOVE)
    private List<Task> tasks;
}
