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

    @PostMapping(path="/add") // Map ONLY POST Requests
    public @ResponseBody String addRestaurant (@RequestParam String username
            , @RequestParam String email, @RequestParam String password) {
        // @ResponseBody means the returned String is the response, not a view name
        // @RequestParam means it is a parameter from the GET or POST request

        RestaurantUser r = new RestaurantUser();
        r.setUsername(username);
        r.setEmail(email);
        r.setPassword(password);
        r.setName(username);
        restaurantUserRepository.save(r);
        return "Saved";
    }
}





