package com.umitkirtil.demos.vaadinflow2neo4jspringsec.frontend.util.css;

public enum PointerEvents {

    AUTO("auto"), NONE("none");

    private String value;

    PointerEvents(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
