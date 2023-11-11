package com.developez.Spring.boot.blog.API.utils;

import com.developez.Spring.boot.blog.API.entity.Permission;
import com.developez.Spring.boot.blog.API.entity.PermissionEntity;
import com.developez.Spring.boot.blog.API.repository.PermissionRepository;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class DataInizializer {
    private final PermissionRepository permissionRepository;

    @Autowired
    public DataInizializer(PermissionRepository permissionRepository) {
        this.permissionRepository = permissionRepository;
    }

    @PostConstruct
    public void initPermissions() {
        for ( Permission perm : Permission.values()) {
            permissionRepository.findByName(perm)
                    .orElseGet(() -> {
                        PermissionEntity newPerm = new PermissionEntity();
                        newPerm.setName(perm);
                        System.out.println("Permesso " + perm + " Creato");
                        return permissionRepository.save(newPerm);
                    });
        }
        System.out.println("|*|*|*|*|*|*|*|*|*|*|*|*|*|*|*|*|*|*|*|*|*|*|*|*|*|*|*|*");
        System.out.println("|*|*|*|*| PERMESSI INIZIALIZZATI CORRETTAMENTE |*|*|*|*|");
        System.out.println("|*|*|*|*|*|*|*|*|*|*|*|*|*|*|*|*|*|*|*|*|*|*|*|*|*|*|*|*");
    }
}
