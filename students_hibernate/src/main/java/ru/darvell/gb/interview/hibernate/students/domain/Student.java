package ru.darvell.gb.interview.hibernate.students.domain;


import lombok.*;

import javax.persistence.*;

@Entity(name = "student")
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String name;
    private String mark;
}
