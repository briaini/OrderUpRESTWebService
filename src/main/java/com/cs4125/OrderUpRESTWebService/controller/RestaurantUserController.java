package com.cs4125.OrderUpRESTWebService.controller;

import com.cs4125.OrderUpRESTWebService.models.RestaurantUser;
import com.cs4125.OrderUpRESTWebService.repositories.RestaurantUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping(path="/restaurant")
public class RestaurantUserController {
    @Autowired
    private RestaurantUserRepository restaurantUserRepository;

    @GetMapping(path="/")
    public @ResponseBody Iterable<RestaurantUser> getAllUsers() {
        // This returns a JSON or XML with the users
        return restaurantUserRepository.findAll();
    }
}





