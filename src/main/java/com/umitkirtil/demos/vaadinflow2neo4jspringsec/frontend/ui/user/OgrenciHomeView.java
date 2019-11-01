package com.umitkirtil.demos.vaadinflow2neo4jspringsec.frontend.ui.user;

import com.umitkirtil.demos.vaadinflow2neo4jspringsec.frontend.MainLayout;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.html.H1;
import com.vaadin.flow.component.notification.Notification;
import com.vaadin.flow.component.notification.NotificationVariant;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.server.VaadinServlet;
import org.springframework.security.access.annotation.Secured;

@Route(value = "user/home", layout = MainLayout.class)
@Secured(value = "user")
public class OgrenciHomeView extends VerticalLayout {

    public OgrenciHomeView() {
        add(new H1("User Home View Hoşgeldiniz"));
        VaadinServlet vaadinServlet = VaadinServlet.getCurrent();

        Button btnShowContext = new Button("Show Context");
        btnShowContext.addClickListener(buttonClickEvent -> {
            Notification.show(VaadinServlet.getCurrent().toString(), 5000, Notification.Position.MIDDLE).addThemeVariants(NotificationVariant.LUMO_SUCCESS);
            System.out.println("servlet info : " + vaadinServlet.getServletInfo());
            System.out.println("servlet name : " + vaadinServlet.getServletName());
            System.out.println("servlet context name : " + vaadinServlet.getServletContext().getServletContextName());
            System.out.println("servlet context context path (sonuna /logout eklenince çıkış yapıyor nays.) : " + vaadinServlet.getServletContext().getContextPath());
        });

        add(btnShowContext);
    }
}