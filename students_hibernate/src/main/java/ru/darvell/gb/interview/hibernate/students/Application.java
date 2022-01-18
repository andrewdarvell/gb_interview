package ru.darvell.gb.interview.hibernate.students;

import org.flywaydb.core.Flyway;
import ru.darvell.gb.interview.hibernate.students.domain.Student;
import ru.darvell.gb.interview.hibernate.students.service.StudentService;

import javax.persistence.EntityNotFoundException;

public class Application {

    public static void main(String[] args) {

        Flyway flyway = Flyway.configure()
                .dataSource("jdbc:mysql://localhost:3306/students", "students", "students_pass").load();
        flyway.migrate();

        var studentService = new StudentService();
        studentService.addStudent(Student.builder().mark("123").name("Антон").build());

        System.out.println(
                studentService.getStudentById(2).orElseThrow(EntityNotFoundException::new)
                        .getName()
        );

        var studentToEdit = studentService.getStudentById(3).orElseThrow(EntityNotFoundException::new);
        studentToEdit.setMark("Тест");

        studentService.updateStudent(studentToEdit);

        studentService.delete(
                studentService.getStudentById(12).orElseThrow(EntityNotFoundException::new)
        );
    }
}
