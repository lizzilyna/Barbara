package it.epicode.Barbara.model;

import jakarta.persistence.*;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Entity
@Data

public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String username;
    private String password;
    private String email;

    @OneToMany (mappedBy = "offeredBy", cascade =CascadeType.ALL)//mappato nel campo "Offerto da", tabella help; le modifiche a User vanno, a cascate, su help)
    @Column(name="offered_helps")
    private List<Help>offeredHelps=new ArrayList<>();


    @OneToMany (mappedBy = "requestedBy", cascade = CascadeType.ALL)
    @Column(name = "requested_helps")
    private List<Help>requestedHelps=new ArrayList<>();



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
        username = username;
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

    public List<Help> getOfferedHelps() {
        return offeredHelps;
    }

    public void setOfferedHelps(List<Help> offeredHelps) {
        this.offeredHelps = offeredHelps;
    }

    public List<Help> getRequestedHelps() {
        return requestedHelps;
    }

    public void setRequestedHelps(List<Help> requestedHelps) {
        this.requestedHelps = requestedHelps;
    }
}