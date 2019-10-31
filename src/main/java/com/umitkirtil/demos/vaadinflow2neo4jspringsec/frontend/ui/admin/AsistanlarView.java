package com.umitkirtil.demos.vaadinflow2neo4jspringsec.frontend.ui.admin;

import com.umitkirtil.demos.vaadinflow2neo4jspringsec.frontend.MainLayout;
import com.vaadin.flow.component.html.H1;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.Route;
import org.springframework.security.access.annotation.Secured;

@Route(value = "asistanlar", layout = MainLayout.class)
@Secured(value = "admin")
public class AsistanlarView extends VerticalLayout {

    public AsistanlarView() {
        add(new H1("Hoşgeldiniz Admin !"));
    }
}
