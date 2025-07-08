package org.example.empltest.service;

import jakarta.persistence.Entity;
import org.example.empltest.domain.annotation.OwnAnnotation;
import org.springframework.stereotype.Service;

import java.io.File;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;


@Service
public class EntityService {

    private static final String ENTITIES_PACKAGE = "org.example.empltest.domain.entity";

    public List<String> getAllEntityNames() {

        List<String> entityNames = new ArrayList<>();

        try {
            ClassLoader classloader = Thread.currentThread().getContextClassLoader();
            String path = ENTITIES_PACKAGE.replace('.', '/');
            URL packageURL = classloader.getResource(path);

            if (packageURL != null) {
                File packageDir = new File(packageURL.getFile());
                if (packageDir.exists()) {
                    for (File file : packageDir.listFiles()) {
                        String fileName = file.getName();
                        if (fileName.endsWith(".class")) {
                            String className = ENTITIES_PACKAGE + '.' + fileName.substring(0, fileName.length() - 6);
                            Class<?> cls = Class.forName(className);

                            if (cls.isAnnotationPresent(OwnAnnotation.class)) {
                                entityNames.add(cls.getSimpleName());
                            }
                        }
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return entityNames;

    }
}
