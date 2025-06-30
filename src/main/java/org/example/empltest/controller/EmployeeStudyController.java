package org.example.empltest.controller;

import lombok.RequiredArgsConstructor;
import org.example.empltest.domain.dto.EmployeeStudyDto;
import org.example.empltest.domain.dto.EmployeeStudyRequest;
import org.example.empltest.domain.entity.EmployeeStudyEntity;
import org.example.empltest.service.EmployeeStudyService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/study")
@RequiredArgsConstructor
public class EmployeeStudyController {
    private final EmployeeStudyService service;

    @PostMapping
    public ResponseEntity<String> create(@RequestBody EmployeeStudyRequest request) {
        service.create(request.getEmployeeId(), request.getStudyName());
        return ResponseEntity.ok("created");
    }


    @GetMapping("/get-all")
    public ResponseEntity<List<EmployeeStudyDto>> getAll() {
        return ResponseEntity.ok(service.getAllDto());
    }


    @PutMapping("/update")
    public ResponseEntity<String> update(@RequestBody EmployeeStudyRequest request) {
        service.update(request.getEmployeeId(), request.getStudyName());
        return ResponseEntity.ok("updated");
    }


    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable UUID id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/get_all_short")
    public ResponseEntity<List<EmployeeStudyDto>> getAllShort() {
        return ResponseEntity.ok(service.getAllShort());
    }

}
