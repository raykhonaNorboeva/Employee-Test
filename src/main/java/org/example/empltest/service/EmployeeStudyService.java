package org.example.empltest.service;

import lombok.RequiredArgsConstructor;
import org.example.empltest.domain.dto.EmployeeStudyDto;
import org.example.empltest.domain.dto.mapper.EmployeeStudyMapper;
import org.example.empltest.domain.entity.EmployeeEntity;
import org.example.empltest.domain.entity.EmployeeStudyEntity;
import org.example.empltest.repository.EmployeeRepository;
import org.example.empltest.repository.EmployeeStudyRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class EmployeeStudyService {
    private final EmployeeStudyRepository studyRepo;
    private final EmployeeRepository employeeRepo;
    private final EmployeeStudyMapper mapper;

    public EmployeeStudyEntity create(UUID employeeId, String studyName) {
        EmployeeEntity employee = employeeRepo.findById(employeeId)
                .orElseThrow(() -> new RuntimeException("EmployeeEntity not found"));

        EmployeeStudyEntity study = new EmployeeStudyEntity();
        study.setEmployee(employee);
        study.setStudyName(studyName);
        return studyRepo.save(study);
    }

    public List<EmployeeStudyDto> getAllDto() {
        List<EmployeeStudyEntity> entities = studyRepo.findAll();
        return mapper.toDtoList(entities);
    }


    public List<EmployeeStudyDto> getByEmployeeIdDto(UUID employeeId) {
        List<EmployeeStudyEntity> list = studyRepo.findByEmployee_Id(employeeId);
        return mapper.toDtoList(list);
    }


    public EmployeeStudyEntity update(UUID id, String newStudyName) {
        EmployeeStudyEntity study = studyRepo.findById(id)
                .orElseThrow(() -> new RuntimeException("Study not found"));
        study.setStudyName(newStudyName);
        return studyRepo.save(study);
    }

    public void delete(UUID id) {
        if (!studyRepo.existsById(id)) {
            throw new RuntimeException("Study not found");
        }
        studyRepo.deleteById(id);
    }

    public List<EmployeeStudyDto> getAllShort() {
        return studyRepo.findAll().stream()
                .map(study -> new EmployeeStudyDto(
                        study.getEmployee().getId(),
                        study.getEmployee().getName(),
                        study.getStudyName()
                ))
                .collect(Collectors.toList());
    }

}
