package com.umitkirtil.demos.vaadinflow2neo4jspringsec.frontend.util.css;

public enum FlexWrap {

    NO_WRAP("nowrap"), WRAP("wrap"), WRAP_REVERSE("wrap-reverse");

    private String value;

    FlexWrap(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
