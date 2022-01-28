package ru.darvell.gb.interview.studentsspting.students_spring.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.darvell.gb.interview.studentsspting.students_spring.domain.Student;
import ru.darvell.gb.interview.studentsspting.students_spring.domain.api.StudentDTO;
import ru.darvell.gb.interview.studentsspting.students_spring.exception.NotFoundException;
import ru.darvell.gb.interview.studentsspting.students_spring.repository.StudentRepository;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class StudentService {

    private final StudentRepository studentRepository;

    public List<StudentDTO> findAllStudents() {
        return studentRepository.findAll().stream()
                .map(StudentDTO::new)
                .collect(Collectors.toList());
    }

    public StudentDTO addOrUpdateStudent(StudentDTO dto) {
        return dto.getId() == null ? addStudent(dto) : updateStudent(dto);
    }

    protected StudentDTO addStudent(StudentDTO dto) {
        return new StudentDTO(studentRepository.saveAndFlush(
                Student.builder()
                        .age(dto.getAge())
                        .name(dto.getName())
                        .build()
        ));
    }

    protected StudentDTO updateStudent(StudentDTO dto) {
        var student = getStudentById(dto.getId());
        student.setName(dto.getName());
        student.setAge(dto.getAge());
        return new StudentDTO(studentRepository.saveAndFlush(student));
    }

    protected Student getStudentById(Integer id) {
        return studentRepository.findById(id)
                .orElseThrow(this::getNotFoundException);
    }

    public StudentDTO getStudentDTOById(Integer id) {
        return new StudentDTO(getStudentById(id));
    }

    public void delete(Integer id) {
        studentRepository.delete(getStudentById(id));
    }

    protected NotFoundException getNotFoundException() {
        return new NotFoundException("Student not found");
    }
}
