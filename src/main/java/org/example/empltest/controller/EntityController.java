package org.example.empltest.controller;

import lombok.RequiredArgsConstructor;
import org.example.empltest.service.EntityService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/entity")
@RequiredArgsConstructor
public class EntityController {

    private final EntityService entityService;

    @GetMapping("/entity-names")
    public ResponseEntity<List<String>> getEntityNames() {
        return ResponseEntity.ok(entityService.getAllEntityNames());
    }
}
