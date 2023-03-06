package com.oneHundre.oneHundre.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Data
@Entity
@Table(name="director")
public class Director {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name="id")
    private int id;

    @Column(name="director_name")
    private String director_name;

    @Column(name="date")
    private String date;

    @Column(name="country")
    private String country;

    @Column(name="photo")
    private String photo;

    //Conexion muchos a uno con peliculas
    @OneToMany(mappedBy = "director",cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.EAGER)
    @JsonBackReference
    private List<Movie> peliculas;
}
