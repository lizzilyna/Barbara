package it.epicode.Barbara.repositories;

import it.epicode.Barbara.model.Help;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface HelpRepository extends JpaRepository <Help, Integer>, PagingAndSortingRepository <Help, Integer> {
List<Help>findByTempoStimato(double tempoStimato);
}
