package com.oneHundre.oneHundre.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Data
@Entity
@Table(name="actor")
public class Actor {
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
            inverseJoinColumns = @JoinColumn(name = "fk_id_peli"))
    //@JsonIgnore
    private List<Movie> movies;

}
