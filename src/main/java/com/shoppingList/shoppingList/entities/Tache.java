package com.shoppingList.shoppingList.entities;

import jakarta.persistence.*;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;
@Entity
@Data
@Table(name = "tache")
public class Tache implements Serializable {

    @Id
    @GeneratedValue
    @Column(nullable = false, updatable = false)
    private Long id;

    private String nameTache;
    private  String description;
    private Boolean statut;

    @ManyToOne
    @JoinColumn(name = "course_id")
    private Course course;

}
