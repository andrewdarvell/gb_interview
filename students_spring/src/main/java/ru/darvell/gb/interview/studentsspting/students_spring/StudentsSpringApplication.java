package ru.darvell.gb.interview.studentsspting.students_spring;

import org.flywaydb.core.Flyway;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class StudentsSpringApplication {

    public static void main(String[] args) {
        Flyway flyway = Flyway.configure()
                .dataSource("jdbc:mysql://localhost:3306/students_spring", "students_spring", "students_pass").load();
        flyway.migrate();

        SpringApplication.run(StudentsSpringApplication.class, args);
    }

}
