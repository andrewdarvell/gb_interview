package ru.darvell.gb.interview.studentsspting.students_spring.domain.api;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import ru.darvell.gb.interview.studentsspting.students_spring.domain.Student;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class StudentDTO {
    private Integer id;
    private String name;
    private Integer age;

    public StudentDTO(Student that) {
        id = that.getId();
        name = that.getName();
        age = that.getAge();
    }
}
