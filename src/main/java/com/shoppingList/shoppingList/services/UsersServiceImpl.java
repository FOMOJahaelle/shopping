package com.shoppingList.shoppingList.services;

import com.shoppingList.shoppingList.entities.Tache;
import com.shoppingList.shoppingList.entities.Users;
import com.shoppingList.shoppingList.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UsersServiceImpl implements  UsersService{

    @Autowired
    private  final UserRepository userRepository;

    public UsersServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public Users getOne(Long id) {
        return userRepository.getOne(id);
    }

    @Override
    public List<Users> findAll() {
        return userRepository.findAll();
    }

    @Override
    public List<Users> findByUserName(String username) {
        return  userRepository.findByUserName(username);
    }
}
