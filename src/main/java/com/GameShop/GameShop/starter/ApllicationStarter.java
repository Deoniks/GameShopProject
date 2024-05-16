package com.GameShop.GameShop.starter;

import com.GameShop.GameShop.domain.game.Description;
import com.GameShop.GameShop.domain.game.Game;
import com.GameShop.GameShop.domain.game.Genre;
import com.GameShop.GameShop.domain.gamer.Gamer;
import com.GameShop.GameShop.service.game.DescriptionService;
import com.GameShop.GameShop.service.game.GameService;
import com.GameShop.GameShop.service.game.GenreService;
import com.GameShop.GameShop.service.gamer.GamerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.HashSet;
import java.util.Set;

@Component
public class ApllicationStarter implements CommandLineRunner {

    @Autowired
    private GameService gameService;

    @Autowired
    private GenreService genreService;

    @Autowired
    private DescriptionService descriptionService;

    @Autowired
    private GamerService gamerService;

    @Override
    public void run(String... args) throws Exception {
        Genre action = new Genre("Action");
        genreService.save(action);

        Genre rpg = new Genre("Rpg");
        genreService.save(rpg);

        Description descrDoom = new Description("good action slasher");
        descriptionService.save(descrDoom);

        Description descrQuake = new Description("good slasher");
        descriptionService.save(descrQuake);

        Description descWitcher = new Description("good rpg game");
        descriptionService.save(descWitcher);

        Description descWitcher2 = new Description("epic rpg game");
        descriptionService.save(descWitcher2);


        Game doom = new Game("Doom",18,500,descrDoom,action);
        gameService.save(doom);

        Game theWitcher = new Game("The witcher",18,650,descWitcher,rpg);
        gameService.save(theWitcher);

        Game quake = new Game("Quake",18,500,descrQuake,action);
        gameService.save(quake);

        Game theWitcher2 = new Game("The witche2r",18,650,descWitcher2,rpg);
        gameService.save(theWitcher2);
        theWitcher2.setName("The Witcher 2");
        gameService.update(4L,theWitcher2);

        Set<Game> games1 = new HashSet<>();
        games1.add(doom);
        games1.add(quake);

        Set<Game> games2 = new HashSet<>();
        games2.add(theWitcher);
        games2.add(theWitcher2);

        Gamer deo = new Gamer("Deonis","Deo",games1);
        gamerService.save(deo);


        Gamer deos = new Gamer("Deoniss","Deos",games1);
        gamerService.save(deos);

        gamerService.addGameToGamer(2L,4L);

    }
}
