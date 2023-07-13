package dev.chrono.chronochallenge;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@EnableJpaAuditing
@SpringBootApplication
public class ChronoChallengeApplication {

	public static void main(String[] args) {
		SpringApplication.run(ChronoChallengeApplication.class, args);
	}

}
