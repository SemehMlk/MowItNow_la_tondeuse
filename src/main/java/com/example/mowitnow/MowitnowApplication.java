package com.example.mowitnow;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;

import com.example.mowitnow.Exceptions.MowItNowException;
import com.example.mowitnow.services.MowItNowService;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

@SpringBootApplication
public class MowitnowApplication implements CommandLineRunner {

	@Autowired
    private MowItNowService mowItNowService;

    @Autowired
    private ResourceLoader resourceLoader;
	
	public static void main(String[] args) {
		SpringApplication.run(MowitnowApplication.class, args);
	}

	@Override
    public void run(String... args) throws Exception {
        try {
            String fileName = "tondeuse.txt";
            Resource resource = resourceLoader.getResource("classpath:" + fileName);
            String input = new String(Files.readAllBytes(Paths.get(resource.getURI())));
            String result = mowItNowService.process(input);
            System.out.println("Result:\n" + result);
        } catch (IOException e) {
            throw new MowItNowException("Failed to read input file: " + e.getMessage());
        }
    }
}
