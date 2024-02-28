package it.epicode.Barbara.services;

import it.epicode.Barbara.model.User;
import it.epicode.Barbara.repositories.UserRepository;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Data
@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    public List<User> getAllUsers(){
        return userRepository.findAll();
    }
    public Optional<User> getUserById(int id){
        return userRepository.findById(id);
    }

    public User createUser (User user) {
        return userRepository.save(user);
    }

    public User updateUser(int id, User user) {
        if(userRepository.existsById(id)){
            user.setId(id);
            return userRepository.save(user);
        }
        return null;
    }

    public void deleteUser(int id){
        userRepository.deleteById(id);
    }
}
