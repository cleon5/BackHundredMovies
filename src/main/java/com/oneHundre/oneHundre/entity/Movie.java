package com.oneHundre.oneHundre.entity;

import com.fasterxml.jackson.annotation.*;
import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Data
@Entity
@Table(name="pelicula")
public class Movie {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name="id")
    private int id;

    @Column(name="name")
    private String name;

    @Column(name="link")
    private String link;

    @Column(name="trailer")
    private String trailer;

    @Column(name="poster")
    private String poster;

    @Column(name="fecha_estreno")
    private String fecha_estreno;

    @Column(name="calificacion")
    private String calificacion;

    //Fks
    @JoinColumn(name="fk_id_disponible")
    private int fk_id_disponible;

    @JoinColumn(name="fk_id_pregunta")
    private int fk_id_pregunta;

    @JoinColumn(name="fk_id_saga")
    private int fk_id_saga;

    @JoinColumn(name="fk_id_director")
    private int fk_id_director;

    //conexiones a otras tablas
    @OneToOne(mappedBy = "movie",cascade = CascadeType.ALL)
    @JoinColumn(name = "fk_id_disponible")
    private Disponible disponible;

    @OneToOne(mappedBy = "movie",cascade = CascadeType.ALL)
    @JoinColumn(name = "fk_id_pregunta")
    private Pregunta pregunta;

    @ManyToOne(fetch = FetchType.EAGER, optional = false)
    @JoinColumn(name="fk_id_saga", insertable = false, updatable = false)
    private Saga saga;

    @ManyToOne(fetch = FetchType.EAGER, optional = false)
    @JoinColumn(name="fk_id_director", insertable = false, updatable = false)
    private Director director;

    @ManyToMany
    @JoinTable(name = "inter_act_peli",
            joinColumns = @JoinColumn(name = "fk_id_peli"),
            inverseJoinColumns = @JoinColumn(name = "fk_id_actor"))
    private List<Actores> actores;

    @ManyToMany
    @JoinTable(name = "inter_genero_peli",
            joinColumns = @JoinColumn(name = "fk_id_peli"),
            inverseJoinColumns = @JoinColumn(name = "fk_id_genero"))
    private List<Genero> generos;

}
