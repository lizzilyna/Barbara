package it.epicode.Barbara.services;

import it.epicode.Barbara.exceptions.NotFoundException;
import it.epicode.Barbara.model.Help;
import it.epicode.Barbara.model.HelpRequest;
import it.epicode.Barbara.model.User;
import it.epicode.Barbara.repositories.HelpRepository;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Data
@Service
public class HelpService {

    @Autowired
    private HelpRepository helpRepository;

    @Autowired
    private UserService userService;

    public Page<Help> getAllHelps(Pageable pageable) {
        return helpRepository.findAll(pageable);
    }

    public Help getHelpById(int id) throws NotFoundException {
        return helpRepository.findById(id).
                orElseThrow(() -> new NotFoundException("Help con id=" + id + " non trovato"));
    }

    public Help createHelp(HelpRequest helpRequest) throws NotFoundException {
        User offeredBy = userService.getUserById(helpRequest.getOfferedBy().getId());
        User requestedBy = userService.getUserById(helpRequest.getRequestedBy().getId());
        Help help = new Help(helpRequest.getNome(), helpRequest.getValore(), helpRequest.getTempoStimato(), helpRequest.getOfferedBy(), helpRequest.getRequestedBy());
        return helpRepository.save(help);
    }

    public Help updateHelp(int id, HelpRequest helpRequest) throws NotFoundException {
        Help help = getHelpById(id);
        User offeredBy = userService.getUserById(helpRequest.getOfferedBy().getId());
        User requestedBy = userService.getUserById(helpRequest.getRequestedBy().getId());
        help.setNome(helpRequest.getNome());
        help.setValore(helpRequest.getValore());
        help.setTempoStimato(helpRequest.getTempoStimato());
        help.setOfferedBy(helpRequest.getOfferedBy());
        help.setRequestedBy(helpRequest.getRequestedBy());


        return helpRepository.save(help);
    }


    public void deleteHelp(int id) throws NotFoundException {
        Help help = getHelpById(id);
        helpRepository.delete(help);
    }

    public List<Help> getHelpsByTempoStimato(double tempoStimato) {
        return helpRepository.findByTempoStimato(tempoStimato);
    }
}
