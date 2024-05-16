package com.GameShop.GameShop.domain.gamer;

import com.GameShop.GameShop.domain.game.Game;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.HashSet;
import java.util.Set;

@Data
@Entity
@NoArgsConstructor
@Table(name = "gamer")
public class Gamer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String Login;
    @ManyToMany(cascade = CascadeType.MERGE,fetch = FetchType.EAGER)
    @JoinTable(
            name = "gamer_games",
            joinColumns = {@JoinColumn(name = "gamer_id")},
            inverseJoinColumns = {@JoinColumn(name = "game_id")}
    )
    private Set<Game> games = new HashSet<>();

    public Gamer(String name, String login, Set<Game> games) {
        this.name = name;
        Login = login;
        this.games = games;
    }

    public Gamer(Long id, String name, String login, Set<Game> games) {
        this.id = id;
        this.name = name;
        Login = login;
        this.games = games;
    }
}
