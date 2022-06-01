package com.example.demoonur.student;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDate;

import java.util.List;

import static java.time.Month.*;

@Configuration
public class StudentConfig {

    @Bean
    CommandLineRunner commandLineRunner(
            StudentRespository respository) {
        return args -> {
             Student hatice = new Student(
                    1L,
                    "hatice",
                    "hatice.ho@gmail.com",
                    LocalDate.of(2002, JUNE, 27),20
            );

            Student onur = new Student(2L,
                    "Onur",
                    "onur.ho@gmail.com",
                    LocalDate.of(1998, JUNE, 14),23
            );

            respository.saveAll(
                    List.of(hatice,onur)
            );

        };
    }
}
