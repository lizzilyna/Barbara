package it.epicode.Barbara.model;

import jakarta.persistence.*;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Entity
@Data

public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String username;
    private String password;
    private String email;



    @OneToMany(mappedBy = "offeredBy", cascade = CascadeType.ALL)
//mappato nel campo "Offerto da", tabella help; le modifiche a User vanno, a cascate, su help)

    private List<Help> offeredBy = new ArrayList<>();


    @OneToMany(mappedBy = "offeredBy", cascade = CascadeType.ALL)

    private List<Help> requestedby = new ArrayList<>();


    //***COSTRUTTORI***


    public User() {
    }

    public User(String username, String password, String email) {
        this.id = new Random().nextInt(1, Integer.MAX_VALUE);
        this.username = username;
        this.password = password;
        this.email = email;

    }

    //***GETTERS E SETTERS***
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

}