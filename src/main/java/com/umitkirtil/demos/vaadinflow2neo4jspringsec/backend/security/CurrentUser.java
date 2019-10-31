package com.umitkirtil.demos.vaadinflow2neo4jspringsec.backend.security;

import com.umitkirtil.demos.vaadinflow2neo4jspringsec.backend.entity.User;

@FunctionalInterface
public interface CurrentUser {
    User getUser();
}
