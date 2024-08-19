package com.crudExample.assisiments.repository;

import com.crudExample.assisiments.entity.Task;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

@Repository
public interface TaskRepository extends JpaRepository<Task,Long> {
    boolean existsByTitle(String title);
    boolean existsByDescription(String description);
    Page<Task> findAll(Pageable pageable);

}
