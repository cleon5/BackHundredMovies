package com.oneHundre.oneHundre.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name="preguntas")
public class Pregunta {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name="id")
    private int id;

    @Column(name="pregunta")
    private String pregunta;

    @Column(name="respuestaA")
    private String respuestaA;

    @Column(name="respuestaB")
    private String respuestaB;

    @Column(name="respuestaC")
    private String respuestaV;

    @JsonIgnore
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "id")
    private Movie movie;
}
