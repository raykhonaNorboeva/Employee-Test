package org.example.empltest.service;

import jakarta.persistence.Entity;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.ClassPathScanningCandidateComponentProvider;
import org.springframework.core.type.filter.AnnotationTypeFilter;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class EntityService {

    private static final String ENTITIES_PACKAGE = "org.example.empltest.domain.entity";

    public List<String> getAllEntityNames() {
        ClassPathScanningCandidateComponentProvider entities =
                new ClassPathScanningCandidateComponentProvider(false);
        entities.addExcludeFilter(new AnnotationTypeFilter(Entity.class));

        List<String> names = new ArrayList<>();

        for (BeanDefinition bd : entities.findCandidateComponents(ENTITIES_PACKAGE)) {
            try {
                String className = bd.getBeanClassName();
                Class<?> myClass = Class.forName(className);
                names.add(myClass.getSimpleName());
            } catch (ClassNotFoundException e) {
                throw new RuntimeException("Class not found");
            }
        }
        return names;
    }
}
