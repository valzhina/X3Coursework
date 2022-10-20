package com.devmountain.noteApp.entites;

import com.devmountain.noteApp.dtos.NoteDto;
import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

// this is annotation is what tells Spring that this class is being mapped to a data source
@Entity
//Name of a table in DB. This is where you can set what table you want these objects to be mapped to
@Table(name = "Notes")
@Data
@AllArgsConstructor
@NoArgsConstructor

public class Note {
    //Id column
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id; // id would be type Long

    //Column type "text"
    @Column(columnDefinition = "text")
    //column name  body
    private String body;

    @ManyToOne
    @JsonBackReference
    private User user;

    public Note(NoteDto noteDto){
        if (noteDto.getBody() != null){
            this.body = noteDto.getBody();
        }
    }

    /*
    //========================================================
    //Constructors
    public Note(Long id, String body) {
        this.id = id;
        this.body = body;
    }

    //========================================================
    //Getters

    public Long getId() {
        return id;
    }

    public String getBody() {
        return body;
    }


    //========================================================
    //Setters

    public void setId(Long id) {
        this.id = id;
    }

    public void setBody(String body) {
        this.body = body;
    } */
}

