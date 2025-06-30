package org.example.empltest.controller;

import lombok.RequiredArgsConstructor;
import org.example.empltest.domain.dto.EmployeeCreateDto;
import org.example.empltest.domain.dto.EmployeeDto;
import org.example.empltest.domain.dto.UpdatedEmployeeRequest;
import org.example.empltest.service.EmployeeService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/employee")
@RequiredArgsConstructor
public class EmployeeController {
    private final EmployeeService service;

    @PostMapping
    public ResponseEntity<String> create(@RequestBody EmployeeCreateDto employee) {
        service.create(employee);
        return ResponseEntity.ok("saved");
    }


    @GetMapping("/get-all")
    public ResponseEntity<List<EmployeeDto>> getAll() {
        return ResponseEntity.ok(service.getAll());
    }


    @GetMapping("/get-studies-by-employee-id/{id}")
    public ResponseEntity<EmployeeDto> getById(@PathVariable UUID id) {
        EmployeeDto dto = service.getDtoById(id);
        return ResponseEntity.ok(dto);
    }


    @PutMapping("/update")
    public ResponseEntity<EmployeeDto> update(@RequestBody UpdatedEmployeeRequest updated) {
        return ResponseEntity.ok(service.update(updated));
    }


    @DeleteMapping("/{id}")
    public ResponseEntity<String> delete(@PathVariable UUID id) {
        service.delete(id);
        return ResponseEntity.ok("deleted");
    }

}
