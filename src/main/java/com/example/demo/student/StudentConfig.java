package com.example.demo.student;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;

@Configuration
public class StudentConfig {

    //commandline runner/faker to insert records
    @Bean
    CommandLineRunner commandLineRunner(StudentRepository repository){
        return args -> {
           var caleb = new Student("Caleb","mbuguacaleb30@gmail.com",
                    LocalDate.of(1995, Month.AUGUST,28));

            var alex = new Student("alex","alex@gmail.com",
                    LocalDate.of(1995, Month.AUGUST,28));

            var lucy = new Student("alex","alex@gmail.com",
                    LocalDate.of(1991, Month.AUGUST,28));

            repository.saveAll(List.of(caleb,alex,lucy));
        };
    }
}
