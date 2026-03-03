package org.raguram.todo_application.dao;

import org.raguram.todo_application.model.Status;
import org.raguram.todo_application.model.Task;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TaskRepository extends JpaRepository<Task, Long>, JpaSpecificationExecutor<Task> {

    @Query(
            value = "select * from task where user_id = ?1",
            nativeQuery = true)
    List<Task> findAllByUserId(Long userId);

//    List<Task> findByUserData_IdAndStatus(long userId, Status status);
}
