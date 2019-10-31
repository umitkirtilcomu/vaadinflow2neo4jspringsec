package com.umitkirtil.demos.vaadinflow2neo4jspringsec.frontend.util.css;

public enum TextAlign {

    CENTER("center"),
    JUSTIFY("justify"),
    LEFT("left"),
    RIGHT("right");

    private String value;

    TextAlign(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

}
