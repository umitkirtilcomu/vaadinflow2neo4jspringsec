package com.umitkirtil.demos.vaadinflow2neo4jspringsec.backend.repository;

import com.umitkirtil.demos.vaadinflow2neo4jspringsec.backend.entity.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
public interface RoleRepository extends JpaRepository<Role, Long> {
}
