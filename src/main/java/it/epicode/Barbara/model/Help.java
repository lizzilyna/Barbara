package it.epicode.Barbara.model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class Help {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String nome;
    private int valore;
    private double tempoStimato;


}
