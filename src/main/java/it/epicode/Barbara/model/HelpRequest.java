package it.epicode.Barbara.model;

import jakarta.persistence.*;
import lombok.Data;

@Data
public class HelpRequest {

    private int id;
    private String nome;
    private int valore;
    private double tempoStimato;
    private User offeredBy;
    private User requestedBy;

}