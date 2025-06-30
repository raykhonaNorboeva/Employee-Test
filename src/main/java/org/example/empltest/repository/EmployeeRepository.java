package org.example.empltest.repository;

import org.example.empltest.domain.entity.EmployeeEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;
@Repository
public interface EmployeeRepository extends JpaRepository<EmployeeEntity, UUID> {
}
