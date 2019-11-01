package com.umitkirtil.demos.vaadinflow2neo4jspringsec.backend.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.Entity;
import javax.persistence.OneToMany;

/**
 * @author Umit KIRTIL
 */

@Getter
@Setter
@NoArgsConstructor
@Entity
public class Quiz extends AuditModel {

    @Basic
    private String quizAciklama;

    @Basic
    private int gradeLevel;

    @OneToMany(mappedBy = "quiz")
    private List<Soru> sorus;

    @OneToMany(mappedBy = "quiz")
    private List<Sonuc> sonucs = new ArrayList<>();
}