package org.example.empltest.domain.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter
@AllArgsConstructor
public class EmployeeStudyDto {
    private UUID employeeId;
    private String employeeName;
    private String studyName;
}
