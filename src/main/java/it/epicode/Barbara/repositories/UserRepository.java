package it.epicode.Barbara.repositories;

import it.epicode.Barbara.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface UserRepository extends JpaRepository<User, Integer>, PagingAndSortingRepository <User, Integer>{
}
