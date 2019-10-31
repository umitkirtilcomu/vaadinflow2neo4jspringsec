package com.umitkirtil.demos.vaadinflow2neo4jspringsec.frontend.exceptions;

import com.umitkirtil.demos.vaadinflow2neo4jspringsec.frontend.MainLayout;
import com.umitkirtil.demos.vaadinflow2neo4jspringsec.frontend.exceptions.AccessDeniedException;
import com.vaadin.flow.component.Tag;
import com.vaadin.flow.component.dependency.JsModule;
import com.vaadin.flow.component.polymertemplate.PolymerTemplate;
import com.vaadin.flow.router.*;
import com.vaadin.flow.templatemodel.TemplateModel;

import javax.servlet.http.HttpServletResponse;

@Tag("access-denied-view")
@JsModule("./src/views/errors/access-denied-view.js")
@ParentLayout(MainLayout.class)
@PageTitle("Erişim Reddedildi.")
@Route
public class AccessDeniedView extends PolymerTemplate<TemplateModel> implements HasErrorParameter<AccessDeniedException> {

    @Override
    public int setErrorParameter(BeforeEnterEvent beforeEnterEvent, ErrorParameter<AccessDeniedException> errorParameter) {
        return HttpServletResponse.SC_FORBIDDEN;
    }
}
