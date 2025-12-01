package com.example.demo;

import com.example.demo.entities.Client;
import com.example.demo.entities.Voiture;
import com.example.demo.repositories.VoitureRepository;
import com.example.demo.services.ClientService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;

@EnableFeignClients
@SpringBootApplication
public class DemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}


	@Bean
	CommandLineRunner initialiserBaseH2(VoitureRepository voitureRepository, ClientService clientService){
		return args -> {
			Client c1 = clientService.clientById(2L);
			Client c2 = clientService.clientById(1L);

			System.out.println("**************************");
			System.out.println("Id est :" + c2.getId());
			System.out.println("Nom est :" + c2.getNom());
			System.out.println("**************************");
			System.out.println("**************************");
			System.out.println("Id est :" + c1.getId());
			System.out.println("Nom est :" + c1.getNom());
			System.out.println("Age est :" + c1.getAge());
			System.out.println("**************************");

			// Save only id_client, keep client object transient
			voitureRepository.save(new Voiture(null, "Toyota", "A 25 333", "Corolla", c2.getId(), c2));
			voitureRepository.save(new Voiture(null, "Renault", "B 6 3456", "Megane", c2.getId(), c2));
			voitureRepository.save(new Voiture(null, "Peugeot", "A 55 4444", "301", c1.getId(), c1));
		};
	}
}
