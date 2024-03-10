package it.epicode.Barbara.model;

import lombok.Data;

@Data

public class UserRequest {

    private int id;
    private String username;
    private String password;
    private String email;



}