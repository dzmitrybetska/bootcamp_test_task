package com.bootcamp_it.test_task.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import static com.bootcamp_it.test_task.utils.Constants.*;
import static jakarta.persistence.EnumType.STRING;
import static jakarta.persistence.GenerationType.IDENTITY;

@Data
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = USERS)
public class User {

    @Id
    @GeneratedValue(strategy = IDENTITY)
    @Column(name = USER_ID)
    private Long id;

    @Column(name = SURNAME, nullable = false, length = 40)
    private String surname;

    @Column(name = NAME, nullable = false, length = 20)
    private String name;

    @Column(name = PATRONYMIC, nullable = false, length = 40)
    private String patronymic;

    @Column(name = EMAIL, nullable = false, unique = true)
    private String email;

    @Enumerated(STRING)
    @Column(name = ROLE, nullable = false)
    private Role role;
}
