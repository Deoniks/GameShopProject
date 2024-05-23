package com.GameShop.GameShop.domain.gamer;

import com.GameShop.GameShop.domain.game.Game;
import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.util.HashSet;
import java.util.Set;

@Data
@EqualsAndHashCode(callSuper = true)
@Entity
@NoArgsConstructor
@Table(name = "gamer")
public class Gamer extends Profile{

    @ManyToMany(cascade = CascadeType.MERGE,fetch = FetchType.EAGER)
    @JoinTable(
            name = "gamer_games",
            joinColumns = {@JoinColumn(name = "gamer_id")},
            inverseJoinColumns = {@JoinColumn(name = "game_id")}
    )
    private Set<Game> games = new HashSet<>();

    public Gamer(String firstName, String lastName, int age,
                 String login, String password, String country, Set<Game> games) {
        super(firstName, lastName, age, login, password, country);
        this.games = games;
    }

    public Gamer(Long id, String firstName, String lastName, int age, String login, String password, String country, Set<Game> games) {
        super(id, firstName, lastName, age, login, password, country);
        this.games = games;
    }
}
