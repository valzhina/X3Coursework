package com.devmountain.noteApp.entites;

import com.devmountain.noteApp.dtos.UserDto;
import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

// this is annotation is what tells Spring that this class is being mapped to a data source
@Entity
//This is where you can set what table you want these objects to be mapped to
@Table(name = "Users")
@Data
@NoArgsConstructor
@AllArgsConstructor

public class User {
    //Id column
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id; // id would be type Long

    @Column(unique = true)
    private String username;

    @Column
    private String password;

    @OneToMany(mappedBy = "user", fetch = FetchType.LAZY,
            cascade = {CascadeType.MERGE, CascadeType.PERSIST})
    @JsonBackReference
    private Set<Note> noteSet = new HashSet<>();

    public User(UserDto userDto) {
        if (userDto.getUsername() != null) {
            this.username = userDto.getUsername();
        }
        if (userDto.getPassword() != null) {
            this.password = userDto.getPassword();
        }
    }
}

    //========================================================
    //Constructors

//    public User(Long id, String username, String password) {
//        this.id = id;
//        this.username = username;
//        this.password = password;
//    }


    //========================================================
    //Getters

//    public Long getId() {
//        return id;
//    }
//    public String getUsername() {
//        return username;
//    }
//    public String getPassword() {
//        return password;
//    }

    //========================================================
    //Setters

//    public void setId(Long id) {
//        this.id = id;
//    }
//
//    public void setUsername(String username) {
//        this.username = username;
//    }
//
//    public void setPassword(String password) {
//        this.password = password;
//    }



