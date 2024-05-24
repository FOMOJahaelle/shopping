package com.shoppingList.shoppingList.services;

import com.shoppingList.shoppingList.entities.Tache;
import com.shoppingList.shoppingList.entities.Users;

import java.util.List;

public interface UsersService {

    Users getOne (Long id);
    // retourne toutes les utilisateurs
    List<Users> findAll ();
    // retourne un utilisateur a partir de son nom d'utilisateur
    List<Users>findByUserName(String username);
}
