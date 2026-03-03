package org.raguram.todo_application.specification;

import jakarta.persistence.criteria.Predicate;
import org.raguram.todo_application.model.Status;
import org.raguram.todo_application.model.Task;
import org.springframework.data.jpa.domain.Specification;

import java.util.ArrayList;
import java.util.List;

public class TaskSpecification {

    public static Specification<Task> build(long userId,Status status, String taskName){
        return (root, query, cb) ->{
            List<Predicate> predicates = new ArrayList<>();

            predicates.add(cb.equal(root.get("userData").get("id"),userId));

            if(status != null){
                predicates.add(cb.equal(root.get("status"),status));
            }
            if(taskName != null && !taskName.isEmpty()){
                predicates.add(cb.like(root.get("title"), "%"+taskName+"%"));
            }

            return cb.and(predicates.toArray(new Predicate[0]));
        };
    }
}
