package com.umitkirtil.demos.vaadinflow2neo4jspringsec.frontend.ui;

import com.umitkirtil.demos.vaadinflow2neo4jspringsec.backend.StaticFunctions;
import com.umitkirtil.demos.vaadinflow2neo4jspringsec.backend.security.SecurityUtils;
import com.umitkirtil.demos.vaadinflow2neo4jspringsec.frontend.ui.admin.OgrencilerView;
import com.umitkirtil.demos.vaadinflow2neo4jspringsec.frontend.ui.user.OgrenciHomeView;
import com.vaadin.flow.component.UI;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.button.ButtonVariant;
import com.vaadin.flow.component.combobox.ComboBox;
import com.vaadin.flow.component.dialog.Dialog;
import com.vaadin.flow.component.html.Label;
import com.vaadin.flow.component.icon.VaadinIcon;
import com.vaadin.flow.component.notification.NotificationVariant;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.router.*;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.server.PWA;
import org.springframework.security.core.GrantedAuthority;

import java.util.ArrayList;
import java.util.List;

@Route("")
@PWA(name = "COMU Tıp Quizz App", shortName = "PWA Demo")
public class RedirectView extends VerticalLayout implements BeforeEnterObserver {

    @Override
    public void beforeEnter(BeforeEnterEvent event) {
        if (SecurityUtils.isUserLoggedIn()) {
            if (SecurityUtils.getCurrentUserRoles().size() == 1) {
                if (SecurityUtils.isCurrentUserInRole("ogretmen")) {
                    SecurityUtils.userCurrentRole = "ogretmen";
                    event.forwardTo(OgrencilerView.class);
                }

                if (SecurityUtils.isCurrentUserInRole("ogrenci")) {
                    SecurityUtils.userCurrentRole = "ogrenci";
                    event.forwardTo(OgrenciHomeView.class);
                }
            } else {
                List<String> currentUserRoleList = new ArrayList<>();

                SecurityUtils.getCurrentUserRoles().stream().forEach(o -> {
                    currentUserRoleList.add(((GrantedAuthority) o).getAuthority());
                });

                // birden fazla rol bulundu.
                Dialog dialog = new Dialog();
                dialog.setOpened(true);
                dialog.setCloseOnEsc(false);
                dialog.setCloseOnOutsideClick(false);


                VerticalLayout vL = new VerticalLayout();
                vL.setSpacing(true);

                HorizontalLayout hL = new HorizontalLayout();
                hL.setSpacing(true);

                ComboBox<String> cbRolSec = new ComboBox<>();
                cbRolSec.setPlaceholder("Seçim Yapınız !!!");
                cbRolSec.setRequiredIndicatorVisible(true);
                cbRolSec.setRequired(true);
                cbRolSec.setItems(currentUserRoleList);

                Button btnDevamEt = new Button();
                btnDevamEt.addThemeVariants(ButtonVariant.LUMO_SUCCESS);
                btnDevamEt.setIcon(VaadinIcon.ARROW_CIRCLE_RIGHT.create());
                btnDevamEt.addClickListener(buttonClickEvent -> {
                    String value = cbRolSec.getValue();

                    if (value == null || value.isEmpty()) {
                        StaticFunctions.notificationShow("Seçim Yapınız !!! ", NotificationVariant.LUMO_ERROR);
                    } else {
                        if (value.equals("ogretmen")) {
                            SecurityUtils.userCurrentRole = "ogretmen";
                            UI.getCurrent().navigate(OgrencilerView.class);
                            dialog.close();
                        }
                        if (value.equals("ogrenci")) {
                            SecurityUtils.userCurrentRole = "ogrenci";
                            UI.getCurrent().navigate(OgrenciHomeView.class);
                            dialog.close();
                        }
                    }
                });

                hL.add(cbRolSec, btnDevamEt);

                vL.add(new Label("Birden Fazla Rol Bulundu. Combodan Seçin Yapınız !!!"), hL);
                dialog.add(vL);
            }
        }
    }

    /*@Override
    public void setParameter(BeforeEvent beforeEvent, Object o) {
        // bunu da rol değişikliği için yapacağım şimdilik kalsın ...
        // yada direk login'e yönlendirerek yapabiliriz. du bakam...
    }*/
}