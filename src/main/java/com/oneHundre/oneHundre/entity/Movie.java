package com.oneHundre.oneHundre.entity;

import com.fasterxml.jackson.annotation.*;
import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Data
@Entity
@Table(name="pelicula2")//,uniqueConstraints = {@UniqueConstraint(columnNames = {"id"})})

public class Movie {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name="id")
    private int id;

    @Column(name="nombre")
    private String nombre_pelicula;
    @ManyToOne(fetch = FetchType.EAGER, optional = false)
    //@JsonBackReference
    //@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    @JoinColumn(name="fk_id_saga")
    private Saga saga;
    @JoinColumn(name="trailer")
    private String trailer;
    @JoinColumn(name="netflix")
    private String netflix;
    @JoinColumn(name="hbomax")
    private String hbomax;
/*
    @OneToOne(mappedBy = "movie",cascade = CascadeType.ALL)
    @JoinColumn(name = "id")
    private Disponible disponible;*/

    @ManyToMany
    @JoinTable(name = "inter_act_peli",
            joinColumns = @JoinColumn(name = "fk_id_peli"),
            inverseJoinColumns = @JoinColumn(name = "fk_id_actor"))
    private List<Actores> actores;

    /*
    @ManyToOne(cascade = CascadeType.ALL, targetEntity=Saga.class )
    @JoinColumn(name = "id", referencedColumnName = "id",insertable = false, updatable = false)
    @OneToMany(mappedBy = "movie")
    private List<Saga> saga;*/
}
