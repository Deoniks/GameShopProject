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
import java.util.Optional;

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
            Gamer updateGamer = gamerRepository.findById(gamer.getId()).orElse(null);
            updateGamer.setFirstName(gamer.getFirstName());
            updateGamer.setLastName(gamer.getLastName());
            updateGamer.setCountry(gamer.getCountry());
            updateGamer.setLogin(gamer.getLogin());
            updateGamer.setPassword(gamer.getPassword());
            updateGamer.setAge(gamer.getAge());
            updateGamer.setGames(gamer.getGames());
            gamerRepository.save(gamer);
            log.info("Update user: {}", gamerRepository.findById(gamer.getId()));
        }else{
            throw new RuntimeException("Gamer it's not find");
        }
    }

    @Override
    public void delete(Gamer gamer) {
        log.info("Delete user: {}", gamerRepository.findById(gamer.getId()));
        gamerRepository.delete(gamer);
    }

    @Override
    public void addGame(Long gamerId, Game game) {
        Optional<Gamer>optionalGamer = gamerRepository.findById(gamerId);
        if(optionalGamer.isPresent()){
            Gamer gamer = optionalGamer.get();
            gamer.getGames().add(game);
            gamerRepository.save(gamer);
            log.info("Game successfully add",gamerRepository.findById(gamer.getId()));
        }else {
            log.info("Gamer not find");
        }
    }

    @Override
    public Optional<Game> getGameById(Long gamerId, Long gameId) {
        Optional<Gamer>optionalGamer = gamerRepository.findById(gamerId);
        if(optionalGamer.isPresent()){
            Gamer gamer = optionalGamer.get();
            log.info("find game: ", gamer.getGames());
            return gamer.getGames().stream()
                    .filter(game -> game.getId().equals(gameId))
                    .findFirst();
        }else {
            log.info("Game not find");
            return Optional.empty();
        }
    }

    @Override
    public Optional<Gamer> getById(Long id) {
        log.info("Find user: {}", gamerRepository.findById(id));
        return gamerRepository.findById(id);
    }
}
