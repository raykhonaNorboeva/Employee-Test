package org.example.empltest.domain.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter
@AllArgsConstructor
public class EmployeeStudyRequest {
    private UUID employeeId;
    private String studyName;
}
