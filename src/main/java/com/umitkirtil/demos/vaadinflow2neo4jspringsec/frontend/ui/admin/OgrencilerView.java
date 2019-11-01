package com.umitkirtil.demos.vaadinflow2neo4jspringsec.frontend.ui.admin;

import com.umitkirtil.demos.vaadinflow2neo4jspringsec.backend.entity.Ogrenci;
import com.umitkirtil.demos.vaadinflow2neo4jspringsec.backend.repository.OgrenciRepository;
import com.umitkirtil.demos.vaadinflow2neo4jspringsec.backend.repository.UserRepository;
import com.umitkirtil.demos.vaadinflow2neo4jspringsec.frontend.MainLayout;
import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.html.H1;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.data.provider.ListDataProvider;
import com.vaadin.flow.router.Route;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;

@Route(value = "ogrencilerview", layout = MainLayout.class)
@Secured(value = "ogretmen")
public class OgrencilerView extends VerticalLayout {

    @Autowired
    UserRepository userRepository;

    @Autowired
    OgrenciRepository ogrenciRepository;

    List<Ogrenci> ogrenciList;

    Grid<Ogrenci> ogrenciGrid;

    public OgrencilerView() {
        ogrenciList = new ArrayList<>();
        ogrenciGrid = new Grid<>();
    }

    @PostConstruct
    public void init() {

        /// data binding ///
        ogrenciList = ogrenciRepository.findAll();
        ListDataProvider<Ogrenci> ogrenciListDataProvider = new ListDataProvider<>(ogrenciList);
        ogrenciGrid.setDataProvider(ogrenciListDataProvider);
        /// data binding ///

        /// add columns ///
        ogrenciGrid.addColumn(ogrenci -> ogrenciList.indexOf(ogrenci) + 1).setHeader("No");
        ogrenciGrid.addColumn(ogrenci -> {
            return ogrenci.getUser().getTc();
        }).setHeader("TC");
        ogrenciGrid.addColumn(ogrenci -> {
            return ogrenci.getUser().getFirstName();
        }).setHeader("ADI");
        ogrenciGrid.addColumn(ogrenci -> {
            return ogrenci.getUser().getLastName();
        }).setHeader("SOYADI");
        ogrenciGrid.addColumn(ogrenci -> {
            return ogrenci.getUser().getEmail();
        }).setHeader("E - POSTA");
        ogrenciGrid.addColumn(ogrenci -> {
            return ogrenci.getUser().getGradeLevel();
        }).setHeader("SINIFI");
        /// add columns ///

        add(ogrenciGrid);
    }
}
