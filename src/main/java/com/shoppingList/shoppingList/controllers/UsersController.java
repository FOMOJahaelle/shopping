package com.shoppingList.shoppingList.controllers;

import com.shoppingList.shoppingList.services.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/users")
public class UsersController {

    @Autowired
   private final UsersService usersService;

    public UsersController(UsersService usersService) {
        this.usersService = usersService;
    }
}
