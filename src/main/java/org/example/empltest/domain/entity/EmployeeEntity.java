package org.example.empltest.domain.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@Entity
@Table(name = "employees")
public class EmployeeEntity extends BaseEntity {
    private String name;

    @OneToMany(mappedBy = "employee", cascade = CascadeType.ALL)
    private List<EmployeeStudyEntity> studies = new ArrayList<>();

    @OneToOne
    @JoinColumn(name = "user_id", nullable = false)
    private UserEntity userEntity;
}
