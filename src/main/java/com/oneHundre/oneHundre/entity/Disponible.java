package com.oneHundre.oneHundre.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name="disponible")
public class Disponible {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name="id")
    private int id;

    @Column(name="trailer")
    private String trailer;

    @Column(name="netflix")
    private String netflix;

    @Column(name="hbomax")
    private String hbomax;

    @Column(name="appletv")
    private String appletv;

    @Column(name="amazon")
    private String amazon;

    @Column(name="otro")
    private String otro;

    @JsonBackReference
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "id")
    private Movie movie;


}
