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
    private String Username;
    private String password;
    private String email;

    @ElementCollection
    private ArrayList<String> skillsOfferte;

    @ElementCollection
    private ArrayList<String> skillsRichieste;
}