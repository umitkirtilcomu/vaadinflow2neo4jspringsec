package com.umitkirtil.demos.vaadinflow2neo4jspringsec.backend.repository;

import com.umitkirtil.demos.vaadinflow2neo4jspringsec.backend.entity.User;
import org.springframework.data.neo4j.repository.Neo4jRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
public interface UserRepository extends Neo4jRepository<User, Long> {

    User findUserByEmail(String email);
}
