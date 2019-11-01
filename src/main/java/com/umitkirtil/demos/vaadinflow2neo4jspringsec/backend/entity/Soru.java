package com.umitkirtil.demos.vaadinflow2neo4jspringsec.backend.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

/**
 * @author Umit KIRTIL
 */

@Getter
@Setter
@NoArgsConstructor
@Entity
public class Soru extends AuditModel {

    @Basic
    private String soruText;

    @Basic
    private int puan;

    @OneToMany(mappedBy = "soru")
    private List<Secenek> seceneks = new ArrayList<>();

    @ManyToOne
    private Quiz quiz;
}