package ru.toboe512.airlines.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.toboe512.airlines.entity.User;


/**
 * Репозиторий для работы с сущьностью User котора используется для организации аутентификации
 *
 */
@Repository
public interface UserRepository extends JpaRepository<User, Long> {
}
