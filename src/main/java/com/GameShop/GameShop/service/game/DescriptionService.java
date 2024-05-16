package com.GameShop.GameShop.service.game;

import com.GameShop.GameShop.domain.game.Description;
import com.GameShop.GameShop.domain.game.Genre;
import org.apache.coyote.BadRequestException;

import java.util.List;

public interface DescriptionService {
    List<Description> getAll();
    void save(Description description) throws BadRequestException;
    void update(Long id, Description description);
    void delete(Description description);
    Description getById(Long id);
}
