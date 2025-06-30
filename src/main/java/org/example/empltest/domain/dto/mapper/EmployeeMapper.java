package org.example.empltest.domain.dto.mapper;

import org.example.empltest.domain.dto.EmployeeDto;
import org.example.empltest.domain.entity.EmployeeEntity;
import org.example.empltest.domain.entity.EmployeeStudyEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")
public interface EmployeeMapper {

    @Mapping(source = "studies", target = "studyNames")
    EmployeeDto toDto(EmployeeEntity entity);


    default List<String> mapStudyNames(List<EmployeeStudyEntity> studies) {
        if (studies == null) return List.of();
        return studies.stream()
                .map(EmployeeStudyEntity::getStudyName)
                .toList();
    }

}
