package com.GameShop.GameShop.service.gamer.Impl;

import com.GameShop.GameShop.domain.game.Game;
import com.GameShop.GameShop.domain.gamer.Gamer;
import com.GameShop.GameShop.repository.gamer.GamerRepository;
import com.GameShop.GameShop.service.gamer.GamerService;
import org.apache.coyote.BadRequestException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Iterator;
import java.util.List;

@Service
public class GamerServiceImpl implements GamerService {
    private Logger log = LoggerFactory.getLogger(GamerServiceImpl.class);
    @Autowired
    private GamerRepository gamerRepository;

    @Override
    public List<Gamer> getAll() {
        log.info("User all: {}",gamerRepository.findAll());
        return gamerRepository.findAll();
    }

    @Override
    public void save(Gamer gamer) throws BadRequestException {
        gamerRepository.save(gamer);
        log.info("Save user: {}", gamerRepository.findById(gamer.getId()));
    }

    @Override
    public void update(Long id, Gamer gamer) {
        if(!gamerRepository.findById(id).isEmpty()){
            gamerRepository.save(gamer);
            log.info("Update user: {}", gamerRepository.findById(gamer.getId()));
        }
    }

    @Override
    public void delete(Gamer gamer) {
        log.info("Delete user: {}", gamerRepository.findById(gamer.getId()));
        gamerRepository.delete(gamer);
    }

    @Override
    public void addGameToGamer(Long gamerId, Long gameId) {
        Gamer gamer = getById(gamerId);
        if(gamer != null){
            boolean check = gamer.getGames().stream()
                    .anyMatch(game -> game.getId().equals(gameId));
            if(check){
                log.info("The user already owns this game");
            }else {
                Game game = new Game();
                game.setId(gameId);
                gamer.getGames().add(game);
                gamerRepository.save(gamer);
                log.info("User is successfully add game");
            }
        }
    }

    @Override
    public void removeGameFromGamer(Long gamerId, Long gameId) {
        Gamer gamer = getById(gameId);
        if(gamer != null){
            gamer.getGames().removeIf(game -> game.getId().equals(gameId));
            gamerRepository.save(gamer);
        }
    }

    @Override
    public Gamer getById(Long id) {
        log.info("Find user: {}", gamerRepository.findById(id));
        return gamerRepository.findById(id).orElse(null);
    }
}
