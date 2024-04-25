package com.example.Practice12;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import org.apache.logging.log4j.LogManager;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import java.io.*;
import java.security.MessageDigest;
import org.apache.logging.log4j.Logger;


@SpringBootApplication
public class Practice12Application {
	private String inputFile;
	private String outputFile;
	private static final Logger LOGGER = LogManager.getLogger(Practice12Application.class);


	public static void main(String[] args) {
		SpringApplication.run(Practice12Application.class, args);
	}


	@Bean
	public CommandLineRunner CommandLineRunnerBean() {
		LOGGER.info("Bean is compile");

		return (args) -> {
			if (args.length != 2) {
				System.out.println("Usage: java HashFileApp <inputFile> <outputFile>");
				return;
			}

			inputFile = args[0];
			outputFile = args[1];

			// Check if input file exists
			File file = new File(inputFile);
			if (!file.exists()) {
				try (FileWriter writer = new FileWriter(outputFile)) {
					writer.write("null");
					return;
				}
			}

			// Read data from input file
			FileInputStream fis = new FileInputStream(inputFile);
			byte[] data = new byte[(int) file.length()];
			fis.read(data);
			fis.close();

			// Hash the data
			MessageDigest md = MessageDigest.getInstance("SHA-256");
			byte[] hashedData = md.digest(data);

			// Write hashed data to output file
			FileOutputStream fos = new FileOutputStream(outputFile);
			fos.write(hashedData);
			fos.close();

            LOGGER.info("hashed data was written to a file {}", outputFile);
		};
	}

	@PostConstruct
	public void init() {
		LOGGER.info("Program is running");
	}

	@PreDestroy
	public void cleanUp() {
		File file = new File(inputFile);
		boolean isDelete = file.delete();

		LOGGER.info(isDelete ? inputFile + " was deleted"
			: inputFile + " not found, null was written into " + outputFile);
	}
}
