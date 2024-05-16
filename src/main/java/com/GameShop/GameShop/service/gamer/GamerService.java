package com.GameShop.GameShop.service.gamer;


import com.GameShop.GameShop.domain.gamer.Gamer;
import org.apache.coyote.BadRequestException;

import java.util.List;

public interface GamerService {
    List<Gamer> getAll();
    void save(Gamer gamer) throws BadRequestException;
    void update(Long id, Gamer gamer);
    void delete(Gamer gamer);
    void addGameToGamer(Long gamerId, Long gameId);
    void removeGameFromGamer(Long gamerId, Long gameId);
    Gamer getById(Long id);
}
