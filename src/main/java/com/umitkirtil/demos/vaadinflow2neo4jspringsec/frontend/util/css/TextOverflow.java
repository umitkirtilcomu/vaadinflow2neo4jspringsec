package com.umitkirtil.demos.vaadinflow2neo4jspringsec.frontend.util.css;

public enum TextOverflow {

    CLIP("clip"),
    ELLIPSIS("ellipsis");

    private String value;

    TextOverflow(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
