package com.GameShop.GameShop.domain.game;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@NoArgsConstructor
@Table(name = "game")
public class Game {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private int ageLimit;

    private double price;

    @OneToOne(cascade = CascadeType.MERGE, fetch = FetchType.EAGER)  //bidirectional
    private Description description;

    @ManyToOne //bidirectional
    private Genre genre;


    public Game( String name, int ageLimit, double price, Description description, Genre genre) {
        this.name = name;
        this.ageLimit = ageLimit;
        this.price = price;
        this.description = description;
        this.genre = genre;
    }

    public Game(Long id, String name, int ageLimit, double price, Description description, Genre genre) {
        this.id = id;
        this.name = name;
        this.ageLimit = ageLimit;
        this.price = price;
        this.description = description;
        this.genre = genre;
    }
}
