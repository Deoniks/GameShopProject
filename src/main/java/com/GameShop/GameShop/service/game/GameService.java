package com.GameShop.GameShop.service.game;

import com.GameShop.GameShop.domain.game.Game;
import org.apache.coyote.BadRequestException;

import java.util.List;

public interface GameService {
    List<Game>getAll();
    void save(Game game) throws BadRequestException;
    void update(Long id, Game game);
    void delete(Game game);
    Game getById(Long id);
}
