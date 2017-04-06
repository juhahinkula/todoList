package fi.haagahelia.course;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import fi.haagahelia.course.domain.Todo;
import fi.haagahelia.course.domain.TodoRepository;
import fi.haagahelia.course.domain.User;
import fi.haagahelia.course.domain.UserRepository;

@SpringBootApplication
public class TodoListApplication {
	private static final Logger log = LoggerFactory.getLogger(TodoListApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(TodoListApplication.class, args);
	}
	
	@Bean
	public CommandLineRunner studentDemo(TodoRepository repository, UserRepository urepository) {
		return (args) -> {			
			//repository.save(new Todo("Go to school", "Open"));
			//repository.save(new Todo("Eat lunch", "Completed"));
			
			// Create users: admin/admin user/user
			User user1 = new User("user", "$2a$06$3jYRJrg0ghaaypjZ/.g4SethoeA51ph3UD4kZi9oPkeMTpjKU5uo6", "USER");
			User user2 = new User("admin", "$2a$10$0MMwY.IQqpsVc1jC8u7IJ.2rT8b0Cd3b3sfIBGV2zfgnPGtT4r0.C", "ADMIN");
			urepository.save(user1);
			urepository.save(user2);
			
			log.info("fetch all todos");
			for (Todo todo : repository.findAll()) {
				log.info(todo.toString());
			}
		};
	}	
}
