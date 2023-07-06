package com.filip.javathreading;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.scheduling.TaskScheduler;

@SpringBootApplication
public class JavaThreadingApplication {

    public static void main(String[] args) {
        SpringApplication.run(JavaThreadingApplication.class, args);
    }

    @Bean
    public CommandLineRunner runner(
            TaskScheduler taskScheduler
    ) {
        return args -> {
            System.out.println("hello from runner");
        };
    }

}
