package com.example.ticketInformer;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@EnableJpaAuditing
@SpringBootApplication
public class TicketInformerApplication {

	public static void main(String[] args) {
		SpringApplication.run(TicketInformerApplication.class, args);
	}

}
