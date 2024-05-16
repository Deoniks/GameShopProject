package com.GameShop.GameShop.service.game;

import com.GameShop.GameShop.domain.game.Game;
import com.GameShop.GameShop.domain.game.Genre;
import org.apache.coyote.BadRequestException;

import java.util.List;

public interface GenreService {
    List<Genre> getAll();
    void save(Genre genre) throws BadRequestException;
    void update(Long id, Genre genre);
    void delete(Genre genre);
    Genre getById(Long id);
}
