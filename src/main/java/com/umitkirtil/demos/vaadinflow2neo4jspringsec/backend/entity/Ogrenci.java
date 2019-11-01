package com.umitkirtil.demos.vaadinflow2neo4jspringsec.backend.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

/**
 * @author Umit KIRTIL
 */

@Getter
@Setter
@NoArgsConstructor
@Entity
public class Ogrenci extends AuditModel {

    @ManyToOne(fetch = FetchType.EAGER)
    private User user;

    @OneToMany(mappedBy = "ogrenci")
    private List<Sonuc> sonucs = new ArrayList<>();
}