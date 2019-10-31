package com.umitkirtil.demos.vaadinflow2neo4jspringsec.frontend.exceptions;

import com.umitkirtil.demos.vaadinflow2neo4jspringsec.frontend.MainLayout;
import com.vaadin.flow.component.Tag;
import com.vaadin.flow.component.dependency.JsModule;
import com.vaadin.flow.component.polymertemplate.PolymerTemplate;
import com.vaadin.flow.router.*;
import com.vaadin.flow.templatemodel.TemplateModel;

import javax.servlet.http.HttpServletResponse;

@Tag("route-not-found-error")
@ParentLayout(MainLayout.class)
@PageTitle("Opss .. 404 ...")
@JsModule("./src/views/errors/route-not-found-error.js")
public class RouteNotFoundError extends PolymerTemplate<TemplateModel>
        implements HasErrorParameter<NotFoundException> {

    @Override
    public int setErrorParameter(BeforeEnterEvent event, ErrorParameter<NotFoundException> parameter) {
        return HttpServletResponse.SC_NOT_FOUND;
    }
}