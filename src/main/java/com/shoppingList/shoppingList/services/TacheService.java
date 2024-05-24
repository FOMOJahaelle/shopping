package com.shoppingList.shoppingList.services;

import com.shoppingList.shoppingList.entities.Course;
import com.shoppingList.shoppingList.entities.Tache;

import java.util.List;

public interface TacheService {


    Tache getOne (Long id);
    List<Tache> findAll();
    Tache create(Tache tache);
    Tache update(Tache tache,Long id);
    void delete(Long id);


}
