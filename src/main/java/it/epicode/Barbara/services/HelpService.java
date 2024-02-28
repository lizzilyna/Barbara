package it.epicode.Barbara.services;

import it.epicode.Barbara.model.Help;
import it.epicode.Barbara.repositories.HelpRepository;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Data
@Service
public class HelpService {
    @Autowired
    private HelpRepository helpRepository;

    public List<Help>getAllHelps(){
        return helpRepository.findAll();
    }

    public Optional<Help>getHelpById (int id){
        return helpRepository.findById(id);
    }

    public Help createHelp (Help help) {
        return helpRepository.save(help);
    }

    public Help updateHelp (int id, Help help) {
        if (helpRepository.existsById(id)) {
            help.setId(id);
            return helpRepository.save(help);
        }
        return null;
    }

public void deleteHelp(int id) {
        helpRepository.deleteById(id);
}

public List<Help> getHelpsByTempoStimato(double tempoStimato){
        return helpRepository.findByTempoStimato (tempoStimato);
}
}
