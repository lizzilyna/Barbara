package it.epicode.Barbara.services;

import it.epicode.Barbara.exceptions.NotFoundException;
import it.epicode.Barbara.model.User;
import it.epicode.Barbara.model.UserRequest;
import it.epicode.Barbara.repositories.UserRepository;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.NoSuchElementException;

@Data
@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    public Page<User> getAllUsers(Pageable pageable) {

        return userRepository.findAll(pageable);
    }

    public User getUserById(int id) {
        return userRepository.findById(id).
                orElseThrow(() -> new NotFoundException("utente con id=" + id + " non trovata"));
    }

    public User createUser(UserRequest userRequest) {
        User user = new User();
        user.setUsername(userRequest.getUsername());
        user.setPassword(userRequest.getPassword());
        user.setEmail(userRequest.getEmail());
        return userRepository.save(user);
    }

    public User updateUser(int id, UserRequest userRequest) throws NotFoundException {
        User u = getUserById(id);
        u.setUsername(userRequest.getUsername());
        u.setPassword(userRequest.getPassword());
        u.setEmail(userRequest.getEmail());
        return userRepository.save(u);
    }


    public void deleteUser(int id) throws NotFoundException {
        User u = getUserById(id);
        userRepository.delete(u);
    }
}
