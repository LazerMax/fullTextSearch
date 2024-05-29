package org.example.runner;

import com.github.javafaker.Faker;
import org.example.model.Worker;
import org.example.repo.WorkerRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.Random;

@Component
public class GenerateWorkers implements CommandLineRunner {
    @Autowired
    private WorkerRepo workerRepo;

    private Faker faker = new Faker();

    @Override
    public void run(String... args) throws Exception {
        for (int i = 0; i < 10; i++) {
            int salary = (new Random()).nextInt((10000 - 1000) + 1) + 1000;
            int workExperience = (new Random()).nextInt((100 - 1) + 1) + 1;
            String responsibilities = faker.lorem().paragraph();
            workerRepo.save(new Worker(i + 1, faker.job().position(), salary, responsibilities));
        }
    }
}