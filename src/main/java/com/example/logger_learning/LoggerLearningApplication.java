package com.example.logger_learning;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@EnableScheduling
@SpringBootApplication
public class LoggerLearningApplication {

	public static void main(String[] args) {
		SpringApplication.run(LoggerLearningApplication.class, args);
	}

}
