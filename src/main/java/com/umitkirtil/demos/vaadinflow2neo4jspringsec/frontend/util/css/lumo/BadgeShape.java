package com.umitkirtil.demos.vaadinflow2neo4jspringsec.frontend.util.css.lumo;

public enum BadgeShape {

    NORMAL("normal"), PILL("pill");

    private String style;

    BadgeShape(String style) {
        this.style = style;
    }

    public String getThemeName() {
        return style;
    }

}
