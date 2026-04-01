package com.joaofrancisco.todosimple.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.joaofrancisco.todosimple.models.Task;

@Repository
public interface TaskRepository extends JpaRepository<Task, Long>{
    
    // METODO 1 - Melhor Metodo
    List<Task> findByUser_Id(long id);

    // METODO 2
    // @Query(value = "SELECT t FROM Task t WHERE t.user.id =:id")
    // List<Task> findByUser_Id(@Param ("_id") long id);

    // METODO 3
    // @Query(value = "SELECT * FROM task t WHERE t.user_id = :id", nativeQuery = true)
    // List<Task> findByUser_Id(@Param ("id") long id);
}
