package org.example.empltest.domain.dto.mapper;

import org.example.empltest.domain.dto.EmployeeStudyDto;
import org.example.empltest.domain.entity.EmployeeStudyEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")
public interface EmployeeStudyMapper {

    @Mapping(source = "employee.id", target = "employeeId")
    @Mapping(source = "employee.name", target = "employeeName")
    @Mapping(source = "studyName", target = "studyName")
    EmployeeStudyDto toDto(EmployeeStudyEntity entity);

    List<EmployeeStudyDto> toDtoList(List<EmployeeStudyEntity> entities);
}
