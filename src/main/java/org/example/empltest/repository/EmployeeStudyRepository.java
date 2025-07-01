package org.example.empltest.repository;

import org.example.empltest.domain.entity.EmployeeStudyEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface EmployeeStudyRepository extends JpaRepository<EmployeeStudyEntity, UUID> {
    List<EmployeeStudyEntity> findByEmployee_Id(UUID employeeId);
}
