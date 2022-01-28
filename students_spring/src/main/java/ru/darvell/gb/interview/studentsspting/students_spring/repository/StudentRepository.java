package ru.darvell.gb.interview.studentsspting.students_spring.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.darvell.gb.interview.studentsspting.students_spring.domain.Student;

@Repository
public interface StudentRepository extends JpaRepository<Student, Integer> {
}
