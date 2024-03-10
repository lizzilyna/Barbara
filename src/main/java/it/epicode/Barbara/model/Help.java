package it.epicode.Barbara.model;

import jakarta.persistence.*;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Entity
@Data
public class Help {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String nome;
    private int valore;
    private double tempoStimato; //se cancello/commento questa riga il main termina con 0, non sparisce la relativa colonna, compaiono le aggiunte nel db ma non le cancellazioni?? SE lo decommento il main gira correttamente. BOOOOOOH

    @ManyToOne
    @JoinColumn (name = "offered_by_id")
    private User offeredBy;

    @ManyToOne
    @JoinColumn (name = "requested_by_id")
    private User requestedBy;



    //***COSTRUTTORI***

    public Help() {
    };

    public Help(String nome, int valore, double tempoStimato, User offeredBy, User requestedBy) {
        this.id =new Random().nextInt(1, Integer.MAX_VALUE);
        this.nome = nome;
        this.valore = valore;
        this.tempoStimato=tempoStimato;
        this.offeredBy = offeredBy;
        this.requestedBy = requestedBy;
    }

   /* public Help(String nome, int valore, double tempoStimato, User offeredBy, User requestedBy) {
        this.nome = nome;
        this.valore = valore;
        this.tempoStimato = tempoStimato;
        this.offeredBy=offeredBy;
        this.requestedBy=requestedBy;
    }*/

    //***GETTER E SETTER***
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getValore() {
        return valore;
    }

    public void setValore(int valore) {
        this.valore = valore;
    }

    public User getOfferedBy() {
        return offeredBy;
    }

    public void setOfferedBy(User offeredBy) {
        this.offeredBy = offeredBy;
    }

    public User getRequestedBy() {
        return requestedBy;
    }

    public void setRequestedBy(User requestedBy) {
        this.requestedBy = requestedBy;
    }
}
