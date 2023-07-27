package br.com.nexus.authserver;

import br.com.nexus.authserver.domain.UserEntity;
import br.com.nexus.authserver.domain.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.time.LocalDateTime;

@SpringBootApplication
public class AuthServerApplication implements CommandLineRunner {

	@Autowired
	private UserRepository repository;

	public static void main(String[] args) {
		SpringApplication.run(AuthServerApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception
	{
		// Inserting the data in the mysql table.
		UserEntity first = new UserEntity(1L, "Beatriz Rodrigues", "beatriz",
				"beatriz@email.com", "$2a$10$JUi.PRYJGN1OBRdSlUfKVOFC4SUnGMrO/yJnASN9BKIFH5y5ielQa",
				UserEntity.Tipo.ADMIN, UserEntity.StatusCadastros.A, LocalDateTime.now(), LocalDateTime.now());
		// ob.save() method
		repository.save(first);
	}
}
