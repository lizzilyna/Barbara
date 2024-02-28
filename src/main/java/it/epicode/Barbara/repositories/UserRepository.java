package it.epicode.Barbara.repositories;

import it.epicode.Barbara.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Integer> {
}
