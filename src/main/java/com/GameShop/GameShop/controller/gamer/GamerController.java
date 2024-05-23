package com.GameShop.GameShop.controller.gamer;

import com.GameShop.GameShop.domain.game.Game;
import com.GameShop.GameShop.domain.gamer.Gamer;
import com.GameShop.GameShop.service.gamer.GamerService;
import org.apache.coyote.BadRequestException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/gamer")
public class GamerController {

    @Autowired
    private GamerService gamerService;

    private Logger log = LoggerFactory.getLogger(GamerController.class);

    @GetMapping("/{id}")
    public Gamer findById(@PathVariable Long gamerId){
        log.info("Find gamer: ", gamerService.getById(gamerId));
        return gamerService.getById(gamerId).orElse(null);
    }

    @GetMapping
    public List<Gamer> findAll(){
        return gamerService.getAll();
    }

    @GetMapping("/{gamerId}/games/{gameId}")
    public Game findGameById(@PathVariable Long gamerId, @PathVariable Long gameId){
        Game game  = gamerService.getGameById(gamerId,gameId).orElse(null);
        log.info("Find game: ", game);
        return game;
    }

    @PostMapping
    public void save(@RequestBody Gamer gamer)throws BadRequestException {
        try {
            gamerService.save(gamer);
            log.info("Save new gamer: ", gamerService.getById(gamer.getId()));
        }catch (BadRequestException e){
            log.info("Don't save. Bad request");
        }
    }

    @PutMapping
    public void update(@PathVariable Long gamerId, @RequestBody Gamer gamer){
        gamerService.update(gamerId,gamer);
        log.info("Update gamer: ", gamerService.getById(gamerId));
    }

    @DeleteMapping("/{gamerId}")
    public void delete(@PathVariable Long gamerId){
        Gamer gamer = gamerService.getById(gamerId).orElse(null);
        if(gamer != null){
            log.info("Gamer delete: ", gamerService.getById(gamerId));
            gamerService.delete(gamer);
        }
    }


}
