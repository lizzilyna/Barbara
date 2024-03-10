package it.epicode.Barbara.controllers;

import it.epicode.Barbara.model.User;
import it.epicode.Barbara.model.UserRequest;
import it.epicode.Barbara.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.NoSuchElementException;

@RestController
@RequestMapping ("/api/users")
public class UserController {
    @Autowired
    private UserService userService;

    @GetMapping("/users")
    public Page<User> getAll(Pageable pageable) {
        return userService.getAllUsers(pageable);
    }

    @GetMapping("/users/{id}")
    public User getUserById(@PathVariable int id) {
        return userService.getUserById(id);

    }

    @PostMapping("/users")
    public User createUser (@RequestBody UserRequest userRequest){
        return userService.createUser(userRequest);
    }

    @PutMapping("/users/{id}")
    public User updateUser(@PathVariable int id, @RequestBody UserRequest userRequest){
            return userService.updateUser(id,userRequest);
        }


    @DeleteMapping("/users/{id}")
    public void deleteUser(@PathVariable int id){

       userService.deleteUser(id);

    }
}
