package lexicon.se.market_api.controller;

package com.marketplace.controller;


import lexicon.se.market_api.domain.dto.UserDTO;
import lexicon.se.market_api.service.UserService;
import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/users")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/register")
    public User registerUser(@RequestBody UserDTO userDTO) {
        return userService.registerUser(userDTO);
    }

    @PostMapping("/login")
    public User loginUser(@RequestBody UserDTO userDTO) {
        return userService.authenticateUser(userDTO.getEmail(), userDTO.getPassword());
    }
}
