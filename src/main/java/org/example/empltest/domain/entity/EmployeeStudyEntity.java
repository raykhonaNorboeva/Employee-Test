package org.example.empltest.domain.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.example.empltest.domain.annotation.OwnAnnotation;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@Entity
@OwnAnnotation
@Table(name = "employee_studies")
public class EmployeeStudyEntity extends BaseEntity {

    @ManyToOne
    @JoinColumn(name = "employee_id", nullable = false)
    private EmployeeEntity employee;
    private String studyName;

}
