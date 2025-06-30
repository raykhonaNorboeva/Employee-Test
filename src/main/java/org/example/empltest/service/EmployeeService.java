package org.example.empltest.service;

import lombok.RequiredArgsConstructor;
import org.example.empltest.domain.dto.EmployeeCreateDto;
import org.example.empltest.domain.dto.EmployeeDto;
import org.example.empltest.domain.dto.UpdatedEmployeeRequest;
import org.example.empltest.domain.dto.mapper.EmployeeMapper;
import org.example.empltest.domain.entity.EmployeeEntity;
import org.example.empltest.domain.entity.UserEntity;
import org.example.empltest.repository.EmployeeRepository;
import org.example.empltest.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class EmployeeService {
    private final EmployeeRepository employeeRepository;
    private final UserRepository userRepository;
    private final EmployeeMapper employeeMapper;

    public EmployeeEntity create(EmployeeCreateDto dto) {
        EmployeeEntity newEmployee = new EmployeeEntity();
        newEmployee.setName(dto.getName());

        if (dto.getUserId() != null) {
            UserEntity user = userRepository.findById(dto.getUserId())
                    .orElseThrow(() -> new RuntimeException("User not found"));
            newEmployee.setUserEntity(user);
        }
        return employeeRepository.save(newEmployee);
    }


    public List<EmployeeDto> getAll() {
        return employeeRepository.findAll()
                .stream()
                .map(employeeMapper::toDto)
                .toList();
    }


    public EmployeeEntity getById(UUID id) {
        return employeeRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Employee isn't fount, id=" + id));
    }


    public EmployeeDto getDtoById(UUID id) {
        EmployeeEntity entity = getById(id);
        return employeeMapper.toDto(entity);
    }


    public EmployeeDto update(UpdatedEmployeeRequest updated) {
        EmployeeEntity existing = getById(updated.getId());
        existing.setName(updated.getName());
        employeeRepository.save(existing);
        return employeeMapper.toDto(existing);
    }


    public void delete(UUID id) {
        if (!employeeRepository.existsById(id)) {
            throw new RuntimeException("Employee isn't found, id=" + id);
        }
        employeeRepository.deleteById(id);
    }
}
