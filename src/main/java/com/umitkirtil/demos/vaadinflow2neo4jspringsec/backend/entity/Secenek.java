package com.umitkirtil.demos.vaadinflow2neo4jspringsec.backend.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Basic;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;

/**
 * @author Umit KIRTIL
 */

@Getter
@Setter
@NoArgsConstructor
@Entity
public class Secenek extends AuditModel {
    @Basic
    private String secenekText;

    @Basic
    private String dogruMu;

    @ManyToOne
    Soru soru;
}