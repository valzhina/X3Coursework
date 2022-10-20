package com.devmountain.noteApp.controllers;

import com.devmountain.noteApp.dtos.UserDto;
import com.devmountain.noteApp.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

//defining our RESTful API endpoints and creating the paths that can deliver up the information to the client
@RestController
@RequestMapping("/api/v1/users")
public class UserController {
    //Autowires in our Dependencies,
    @Autowired
    private UserService userService;
    @Autowired
    private PasswordEncoder passwordEncoder;

    //==================================================================================================================
    //method that handles POST requests to be able to register a User
    @PostMapping("/register")
    //hashes the incoming password so that it won’t be unintentionally saved as a raw password to the database
    public List<String> addUser(@RequestBody UserDto userDto){
        //creates a member variable of type “String” called “passHash” and sets it equal to the method available
        // on the “passwordEncoder” called “encode()” and pass in the “password” field from the “userDto” argument
        String passHash = passwordEncoder.encode(userDto.getPassword());

        //invokes the “setPassword()” method available on the “userDto” argument and pass in the “passHash” variable
        userDto.setPassword(passHash);

        //returns the “addUser()” method available on the “userService” dependency and pass in the “userDto” argument
        return userService.addUser(userDto);
    }

    //==================================================================================================================
    //creates the method that takes care of Logging a User in. It is a POST request
    @PostMapping("/login")//annotates the method with the @PostMapping annotation and give it the endpoint “/login”

    //method that returns a “List<String>” called “userLogin” and have it accept a UserDto argument called “userDto”
    //annotates the UserDto argument with @RequestBody so that the JSON request body becomes usable to us
    public List<String> userLogin(@RequestBody UserDto userDto){

        return userService.userLogin(userDto);
        //returns the “userLogin()” method available on “userService” and pass in the “userDto” argument
    }
}
