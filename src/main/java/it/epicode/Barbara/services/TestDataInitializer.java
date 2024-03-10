package it.epicode.Barbara.services;

import it.epicode.Barbara.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Service;

/*@Service
public class TestDataInitializer implements CommandLineRunner {
    private final UserService userService;
    private final HelpService helpService;

    @Autowired
    public TestDataInitializer(UserService userService, HelpService helpService) {
        this.userService=userService;
        this.helpService=helpService;
    }

    @Override
    public void run(String... args)throws Exception{
        User user1 = new User();
        user1.setUsername("username1");
        user1.setPassword("password1");
        user1.setEmail("email1@example.com");

        User user2 = new User();
        user2.setUsername("username2");
        user2.setPassword("password2");
        user2.setEmail("email2@example.com");

        // Salvataggio degli utenti nel database
        userService.createUser(user1);
        userService.createUser(user2);
    }
}
*/