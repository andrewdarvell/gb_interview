package ru.darvell.gb.interview.hibernate.students.service;

import ru.darvell.gb.interview.hibernate.students.dao.AbstractCrudDao;
import ru.darvell.gb.interview.hibernate.students.domain.Student;

import java.util.Optional;

public class StudentService {

    public void addStudent(Student student) {
        student.setId(null);
        getDao().addOrUpdate(student);
    }

    public void updateStudent(Student student) {
        getDao().addOrUpdate(student);
    }

    public Optional<Student> getStudentById(Integer id) {
        return getDao().getById(Student.class, id);
    }

    public void delete(Student student) {
        getDao().delete(student);
    }

    AbstractCrudDao<Student> getDao() {
        return new AbstractCrudDao<>();
    }
}
