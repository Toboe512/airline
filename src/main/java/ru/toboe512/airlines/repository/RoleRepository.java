package ru.toboe512.airlines.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.toboe512.airlines.entity.Role;

@Repository
public interface RoleRepository extends JpaRepository<Role, Long> {
}
