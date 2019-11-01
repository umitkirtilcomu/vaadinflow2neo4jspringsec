/*
package com.umitkirtil.demos.vaadinflow2neo4jspringsec.backend.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.neo4j.ogm.annotation.NodeEntity;
import org.neo4j.ogm.annotation.Relationship;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@NodeEntity
public class User extends AbstractEntity {
    private String email, passwordHash, firstName, lastName;

    @Relationship(type = "ROLES")
    private Set<Role> roles = new HashSet<>();
}*/
