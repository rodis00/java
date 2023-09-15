package com.example.SpringJpaTest;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;

@SpringBootApplication
public class SpringJpaTest {

	public static void main(String[] args) {
		SpringApplication.run(SpringJpaTest.class, args);
	}

	@Bean
	CommandLineRunner commandLineRunner(StudentRepository studentRepository) {
		return args -> {
			Student maria = new Student(
					"Maria",
					"Curie",
					"maria.curie@example.com",
					21,
					"Hello my name is Maria!"
			);

			Student maria2 = new Student(
					"Maria",
					"Jones",
					"maria2.jones@example.com",
					25,
					"Hello my friends."
			);

			Student jan = new Student(
					"Jan",
					"Nowak",
					"jan.nowak@example.com",
					34,
					"Hello my name is Jan"
			);

			System.out.println("\nAdding maria and jan");
			studentRepository.saveAll(List.of(maria, maria2, jan));

			System.out.println("Students count: " + studentRepository.count());
		};
	}
}
