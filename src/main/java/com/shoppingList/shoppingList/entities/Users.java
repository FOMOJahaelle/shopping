package com.shoppingList.shoppingList.entities;

import jakarta.persistence.*;
import lombok.Data;

import java.io.Serializable;
import java.util.List;

@Entity
@Data
@Table(name = "users")
public class Users implements Serializable {
    @Id
    @GeneratedValue
    @Column(nullable = false, updatable = false)
    private Long id;

    private String userName;
    private String passWord;

    @OneToMany(mappedBy = "users", cascade = CascadeType.ALL)
    private List<Course> courses;
}