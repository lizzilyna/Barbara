package it.epicode.Barbara;

import it.epicode.Barbara.model.User;
import it.epicode.Barbara.services.HelpService;
//import it.epicode.Barbara.services.TestDataInitializer;
import it.epicode.Barbara.services.UserService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class BarbaraApplication {

	public static void main(String[] args) {
		SpringApplication.run(BarbaraApplication.class, args);

		//TestDataInitializer testDataInitializer = new TestDataInitializer();
	}

}

/*definisco un metodo testDataInitializer annotato con @Bean.
Questo metodo restituisce un oggetto CommandLineRunner, che verrà eseguito automaticamente al momento dell'avvio dell'applicazione.
All'interno di questo metodo, inserisco il codice per inizializzare i dati di prova utilizzando i servizi corrispondenti (ad esempio, userService e helpService).
Questi servizi devono essere iniettati come parametri nel metodo*/

/*@Bean
public CommandLineRunner testDataInitializer (UserService userService, HelpService helpService) {
	return args -> {

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

	};
}
*/