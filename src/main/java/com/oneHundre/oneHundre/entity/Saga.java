package com.oneHundre.oneHundre.entity;

import com.fasterxml.jackson.annotation.*;
import lombok.Data;

import javax.persistence.*;
import java.util.*;


@Data
@Entity
@Table(name="saga")
@JsonIdentityInfo(
        generator = ObjectIdGenerators.PropertyGenerator.class,
        property = "saga_name")
public class Saga {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name="id")
    private int id;

    @Column(name="saga_name")
    private String saga_name;

   @OneToMany(mappedBy = "saga",cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.EAGER)
   @JsonBackReference
    private List<Movie> peliculas;

}
