package com.GameShop.GameShop.domain.gamer;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@MappedSuperclass
public abstract class Profile {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String firstName;
    private String lastName;
    private int age;

    @Column(unique = true,nullable = false)
    private String login;

    @Column(nullable = false)
    private String password;

    private String country;

    public Profile(String firstName, String lastName, int age, String login, String password, String country) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
        this.login = login;
        this.password = password;
        this.country = country;
    }

    public Profile(Long id, String firstName, String lastName, int age, String login, String password, String country) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
        this.login = login;
        this.password = password;
        this.country = country;
    }
}
