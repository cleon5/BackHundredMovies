package com.oneHundre.oneHundre.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Data
@Entity
@Table(name="genero")
public class Genero {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name="id")
    private int id;

    @Column(name="genero")
    private String genero;

    //Conexion muchos a muchos con peliculas
    @ManyToMany
    @JoinTable(name = "inter_genero_peli",
            joinColumns = @JoinColumn(name = "fk_id_genero"),
            inverseJoinColumns = @JoinColumn(name = "fk_id_pelicula"))
    @JsonIgnore
    private List<Movie> movies;
}
