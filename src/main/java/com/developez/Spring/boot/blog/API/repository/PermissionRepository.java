package com.developez.Spring.boot.blog.API.repository;

import com.developez.Spring.boot.blog.API.entity.Permission;
import com.developez.Spring.boot.blog.API.entity.PermissionEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface PermissionRepository extends JpaRepository<PermissionEntity, Long> {

    Optional<PermissionEntity> findByName( Permission name );

    List<PermissionEntity> findByNameIn( List<Permission> permissions );
}
