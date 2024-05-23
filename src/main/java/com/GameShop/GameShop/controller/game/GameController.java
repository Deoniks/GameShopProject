package com.GameShop.GameShop.controller.game;

import com.GameShop.GameShop.domain.game.Game;
import com.GameShop.GameShop.service.game.GameService;
import org.apache.coyote.BadRequestException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/game")
public class GameController {

    @Autowired
    private GameService gameService;

    private Logger log = LoggerFactory.getLogger(GameController.class);

    @GetMapping("/{gameId}")
    public Game findGameById(@PathVariable Long id){
        log.info("Find game: ",gameService.getById(id));
        return gameService.getById(id);
    }

    @GetMapping
    public List<Game> findAll(){
        log.info("Find all Game");
        return gameService.getAll();
    }

    @PostMapping
    public void save(@RequestBody Game game) throws BadRequestException {
        try {
            gameService.save(game);
            log.info("Game save: ", gameService.getById(game.getId()));
        }catch (BadRequestException e){
            log.error("Bad request");
        }
    }
    @PutMapping("/{id}")
    public void update(@PathVariable Long id, @RequestBody Game game)throws BadRequestException{
        gameService.update(id,game);
        log.info("Update game: ",gameService.getById(id));
    }

    @DeleteMapping
    public void delete(@RequestBody Game game){
        log.info("Delete game: ",gameService.getById(game.getId()));
        gameService.delete(game);
    }
}

