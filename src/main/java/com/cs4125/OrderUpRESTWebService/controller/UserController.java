package com.cs4125.OrderUpRESTWebService.controller;

import com.cs4125.OrderUpRESTWebService.models.User;
import com.cs4125.OrderUpRESTWebService.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import java.util.Collections;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping(path="/user")
public class UserController {
    @Autowired
    private UserRepository userRepository; //bean

    @PostMapping(path="/add") // Map ONLY POST Requests
    public @ResponseBody String addNewUser (@RequestParam String username, @RequestParam String password
            , @RequestParam String email) {
        // @ResponseBody means the returned String is the response, not a view name
        // @RequestParam means it is a parameter from the GET or POST request

        User user = new User();
        user.setUsername(username);
        user.setPassword(password);
        user.setEmail(email);
        userRepository.save(user);
        return "Saved";
    }

    //RequestParam name is key name of call.
    @PostMapping(path="/login") // Map ONLY POST Requests
    public @ResponseBody
    Map<String,String> authenticateLogin(@RequestParam String username, @RequestParam String password) {
        List<User> matchingUserList = userRepository.findByUsername(username);
        if(!matchingUserList.isEmpty())
            return Collections.singletonMap("response", "good");
        else
            return Collections.singletonMap("response", "bad");
    }

    @GetMapping(path="/all")
    public @ResponseBody Iterable<User> getAllUsers() {
        // This returns a JSON or XML with the users
        return userRepository.findAll();
    }
}