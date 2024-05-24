package com.shoppingList.shoppingList.services;


import com.shoppingList.shoppingList.entities.Tache;
import com.shoppingList.shoppingList.repositories.TacheRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TacheServiceImpl implements TacheService{

@Autowired
    TacheRepository tacheRepository;

    /**
     * @param id
     * @return
     */
    @Override
    public Tache getOne(Long id) {
        return tacheRepository.getOne(id);
    }

    /**
     * @return
     */
    @Override
    public List<Tache> findAll() {
        return tacheRepository.findAll();
    }

    /**
     * @param tache
     * @return
     */
    @Override
    public Tache create(Tache tache) {
        Tache tache1 = new Tache();
        tache1.setNameTache(tache.getNameTache());
        tache1.setDescription(tache.getDescription());
        tache1.setStatut(tache.getStatut());
        return tache1;
    }

    /**
     * @param tache
     * @param id
     * @return
     */
    @Override
    public Tache update(Tache tache, Long id) {
        Tache tache1 = tacheRepository.getOne(id);
        tache1.setNameTache(tache.getNameTache());
        tache1.setDescription(tache.getDescription());
        tache1.setStatut(tache.getStatut());
        return tache1;
    }

    /**
     * @param id
     */
    @Override
    public void delete(Long id) {
      tacheRepository.deleteById(id);
    }
}
