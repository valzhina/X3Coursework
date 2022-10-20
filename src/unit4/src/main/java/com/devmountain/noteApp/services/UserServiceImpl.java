package com.devmountain.noteApp.services;

import com.devmountain.noteApp.dtos.UserDto;
import com.devmountain.noteApp.entites.User;
import com.devmountain.noteApp.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {
    @Autowired //Autowire Java Bean from Config into  UserServiceImpl class
    private UserRepository userRepository;
    @Autowired
    private PasswordEncoder passwordEncoder;

    //==============================================================
    //method handles Registering a User
    @Override
    //any time you are saving something to the database include the @Transactional annotation
    // which ensures that the transaction that gets opened with your datasource gets resolved
    @Transactional
    public List<String> addUser(UserDto userDto){
        List<String> response = new ArrayList<>();
        //List accepts a UserDto called “userDto” as an argument and annotate the method
        // with the @Transactional annotation

        User user = new User(userDto); //new method variable of type “User” from NoteApp
        userRepository.saveAndFlush(user); //passed in the “user” object and persisted
        response.add("http://localhost:8080/login.html"); //adds a String to “response” with a success message
                                                        // and return the “response” method variable
        return response;
    }

    //==============================================================
    //method handles User Login
    @Override
    public List<String> userLogin(UserDto userDto){//List accepts a UserDto called “userDto” as an argument
        List<String> response = new ArrayList<>(); //Initiates new method variable of type “List<String>”
        Optional<User> userOptional = userRepository.findByUsername(userDto.getUsername());  //Creates a new method
        //variable called “userOptional” of type “Optional<User>”
        // and sets it equal to the “findByUsername” method in the “userRepository”
        // and passes in the username field from the “userDto” argument.
        //Optionals are there as a way to avoid “NullPointerExeptions”

        if (userOptional.isPresent()){
            // check to see if the password matches the hash by two conditional statements
            if (passwordEncoder.matches(userDto.getPassword(), userOptional.get().getPassword())){
                response.add("http://localhost:8080/home.html");
                response.add(String.valueOf(userOptional.get().getId()));
            } else {
                response.add("Username or password incorrect");
            }
        } else {
            response.add("Username or password incorrect");
        }
        return response;
    }
}

