package com.shoppingList.shoppingList.repositories;

import com.shoppingList.shoppingList.entities.Course;
import com.shoppingList.shoppingList.entities.Tache;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TacheRepository extends JpaRepository<Tache,Long> {

// retourne un utilisateur a partir de son id

     Tache getOne (Long id);
    // retourne toutes les utilisateurs
   List<Tache> findAll ();
   // retourne un utilisateur a partir de son nom d'utilisateur
   //List<Tache>findByUsersUserName(String userName);


}
