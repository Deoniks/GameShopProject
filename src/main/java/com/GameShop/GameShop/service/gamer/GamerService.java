package com.GameShop.GameShop.service.gamer;


import com.GameShop.GameShop.domain.game.Game;
import com.GameShop.GameShop.domain.gamer.Gamer;
import org.apache.coyote.BadRequestException;

import java.util.List;
import java.util.Optional;

public interface GamerService {
    List<Gamer> getAll();
    void save(Gamer gamer) throws BadRequestException;
    void update(Long id, Gamer gamer);
    void delete(Gamer gamer);
    void addGame(Long gamerId, Game game);
    Optional<Game> getGameById(Long gamerId, Long gameId);
    Optional<Gamer> getById(Long id);
}
