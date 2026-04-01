package com.joaofrancisco.todosimple.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.joaofrancisco.todosimple.models.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    // Voce ja tem as query por atributos, como password, id, etc
    // tem os get, find, etc
    // ta tudo dentro do Jpa... que extendemos
}
