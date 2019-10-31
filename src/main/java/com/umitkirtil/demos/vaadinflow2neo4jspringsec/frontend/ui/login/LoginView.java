package com.umitkirtil.demos.vaadinflow2neo4jspringsec.frontend.ui.login;

import com.umitkirtil.demos.vaadinflow2neo4jspringsec.backend.security.SecurityUtils;
import com.umitkirtil.demos.vaadinflow2neo4jspringsec.frontend.ui.RedirectView;
import com.vaadin.flow.component.UI;
import com.vaadin.flow.component.dependency.JsModule;
import com.vaadin.flow.component.dependency.StyleSheet;
import com.vaadin.flow.component.login.LoginI18n;
import com.vaadin.flow.component.login.LoginOverlay;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.page.Viewport;
import com.vaadin.flow.router.BeforeEnterEvent;
import com.vaadin.flow.router.BeforeEnterObserver;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;


@Route(value = "login")
@PageTitle("Login")
@JsModule("./styles/shared-styles.js")
@StyleSheet("https://fonts.googleapis.com/css?family=Dosis:500&display=swap")
@Viewport("width=device-width, minimum-scale=1, initial-scale=1, user-scalable=yes, viewport-fit=cover")
public class LoginView extends VerticalLayout implements BeforeEnterObserver {

    private LoginOverlay login = new LoginOverlay();

    public LoginView() {
        LoginI18n i18n = LoginI18n.createDefault();
        i18n.setHeader(new LoginI18n.Header());
        i18n.getHeader().setTitle("Login");
        i18n.getHeader().setDescription("Kullanıcı adı olarak mail adresinizi giriniz");
        i18n.setForm(new LoginI18n.Form());
        i18n.getForm().setSubmit("Giriş");
        i18n.getForm().setTitle("Giriş");
        i18n.getForm().setUsername("E - Posta");
        i18n.getForm().setPassword("Parola");
        login.setI18n(i18n);

        //setForgotPasswordButtonVisible(true);
        login.setAction("login"); // spring sec.
        login.setOpened(true);
        getElement().appendChild(login.getElement());
    }

    @Override
    public void beforeEnter(BeforeEnterEvent event) {
        if (SecurityUtils.isUserLoggedIn()) {
            UI.getCurrent().navigate(RedirectView.class);
            login.setOpened(false);
        } else {
            login.setOpened(true);
            // event.forwardTo(GenelView.class);
        }
    }
}