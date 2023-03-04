package com.oneHundre.oneHundre.entity;

import com.fasterxml.jackson.annotation.*;
import lombok.Data;

import javax.persistence.*;
import java.util.*;


@Data
@Entity
@Table(name="saga2")//, uniqueConstraints = {@UniqueConstraint(columnNames = {"id"})})
@JsonIdentityInfo(
        generator = ObjectIdGenerators.PropertyGenerator.class,
        property = "saga_nombre")
public class Saga {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name="id")
    private int id;

    @Column(name="saga_nombre")
    private String saga_nombre;

   @OneToMany(mappedBy = "saga",cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.EAGER)
   @JsonBackReference
    private List<Movie> peliculas;

/*
    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.EAGER)
    @JoinColumn(name = "id")
    @ManyToOne
    @JoinColumn(name = "id_saga")
    private Movie movie;*/
}
