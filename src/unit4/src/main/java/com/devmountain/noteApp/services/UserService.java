package com.devmountain.noteApp.services;

import com.devmountain.noteApp.dtos.UserDto;

import javax.transaction.Transactional;
import java.util.List;

public interface UserService {
    //==============================================================
    //method handles Registering a User
    //any time you are saving something to the database include the @Transactional annotation
    // which ensures that the transaction that gets opened with your datasource gets resolved
    @Transactional
    List<String> addUser(UserDto userDto);

    //==============================================================
    //method handles User Login
    List<String> userLogin(UserDto userDto);
}
