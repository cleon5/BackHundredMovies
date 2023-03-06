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

    @Column(name="actor_name")
    private String actor_name;

    @Column(name="date")
    private String date;

    @Column(name="country")
    private String country;

    @Column(name="photo")
    private String photo;

    //Conexion muchos a muchos con peliculas
    @ManyToMany
    @JoinTable(name = "inter_act_peli",
            joinColumns = @JoinColumn(name = "fk_id_actor"),
            inverseJoinColumns = @JoinColumn(name = "fk_id_movie"))
    @JsonIgnore
    private List<Movie> movies;

}
