package com.umitkirtil.demos.vaadinflow2neo4jspringsec.backend.repository;

import com.umitkirtil.demos.vaadinflow2neo4jspringsec.backend.entity.Ogrenci;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OgrenciRepository extends JpaRepository<Ogrenci, Long> {
}
