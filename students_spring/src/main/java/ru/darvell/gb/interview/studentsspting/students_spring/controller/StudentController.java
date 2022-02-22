package ru.darvell.gb.interview.studentsspting.students_spring.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ru.darvell.gb.interview.studentsspting.students_spring.domain.api.StudentDTO;
import ru.darvell.gb.interview.studentsspting.students_spring.service.StudentService;

@Controller
@RequestMapping(value = "/students")
@RequiredArgsConstructor
public class StudentController {

    private final StudentService studentService;

    @PostMapping
    public String addOrUpdateStudent(StudentDTO studentDTO) {
        studentService.addOrUpdateStudent(studentDTO);
        return "redirect:/students";
    }

    @GetMapping
    public String getPage(Model model) {
        model.addAttribute("studentsList", studentService.findAllStudents());
        model.addAttribute("studentToEdit", new StudentDTO());
        model.addAttribute("action", "Добавление");
        return "students";
    }

    @GetMapping(value = "/{id}")
    public String getPageWithSelectedStudent(Model model, @PathVariable(value = "id") Integer id) {
        model.addAttribute("studentsList", studentService.findAllStudents());
        model.addAttribute("studentToEdit", studentService.getStudentDTOById(id));
        model.addAttribute("action", "Изменение");
        return "students";
    }

    @GetMapping(value = "/delete/{id}")
    public String deleteStudent(@PathVariable(value = "id") Integer id) {
        studentService.delete(id);
        return "redirect:/students";
    }
}
