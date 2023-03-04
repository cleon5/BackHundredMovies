package com.oneHundre.oneHundre.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Data
@Entity
@Table(name="actor")
public class Actores {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name="id")
    private int id;
    @Column(name="nombre")
    private String nombre_actor;

    @Column(name="fecha")
    private String fecha;
    @Column(name="nacionalidad")
    private String nacionalidad;

    @ManyToMany
    @JoinTable(name = "inter_act_peli",
            joinColumns = @JoinColumn(name = "fk_id_actor"),
            inverseJoinColumns = @JoinColumn(name = "fk_id_peli"))
    @JsonIgnore
    private List<Movie> movies;

}
