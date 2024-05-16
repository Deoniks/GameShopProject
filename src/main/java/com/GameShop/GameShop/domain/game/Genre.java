package com.GameShop.GameShop.domain.game;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@NoArgsConstructor
@Table(name = "genre")
public class Genre {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String genre;

    public Genre(String genre) {
        this.genre = genre;
    }

    public Genre(Long id, String genre) {
        this.id = id;
        this.genre = genre;
    }
}
