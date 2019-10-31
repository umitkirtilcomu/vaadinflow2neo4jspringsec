package com.umitkirtil.demos.vaadinflow2neo4jspringsec.frontend.util.css;

public enum Position {

    ABSOLUTE("absolute"), FIXED("fixed"), RELATIVE("relative");

    private String value;

    Position(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
