package com.umitkirtil.demos.vaadinflow2neo4jspringsec.frontend.util.css;

public enum BoxSizing {

    BORDER_BOX("border-box"), CONTENT_BOX("content-box");

    private String value;

    BoxSizing(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
