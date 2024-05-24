package com.shoppingList.shoppingList.entities;

import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@Builder
@Table(name = "course")
public class Course implements Serializable {
    @Id
    @GeneratedValue
    @Column(nullable = false, updatable = false)
    private Long id;
    private String name;
    private String description;
    private Date dateCreation;

    @OneToMany(mappedBy = "course", cascade = CascadeType.ALL)
    private List<Tache>taches;

@ManyToOne
    @JoinColumn(name = "users_id")
    private Users users;
}
