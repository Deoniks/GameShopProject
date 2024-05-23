package com.GameShop.GameShop.controller.game;

import com.GameShop.GameShop.domain.game.Genre;
import com.GameShop.GameShop.service.game.GenreService;
import org.apache.coyote.BadRequestException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/genre")
public class GenreController {
    @Autowired
    private GenreService genreService;

    private Logger log = LoggerFactory.getLogger(GameController.class);

    @GetMapping
    public List<Genre> findAll(){
        log.info("Find all: ");
        return genreService.getAll();
    }

    @GetMapping("/{id}")
    public Genre findById(@PathVariable Long id){
        log.info("Find by: ",genreService.getById(id));
        return genreService.getById(id);
    }

    @PostMapping
    public void save(@RequestBody Genre genre)throws BadRequestException {
        try {
            genreService.save(genre);
            log.info("Save genre: ",genreService.getById(genre.getId()));
        }catch (BadRequestException e){
            log.info("Bad request");
        }
    }

    @PutMapping("/{id}")
    public void update(@PathVariable Long id, @RequestBody Genre genre){
        genreService.update(id,genre);
        log.info("Update genre: ", genreService.getById(genre.getId()));
    }

    @DeleteMapping
    public void delete(@RequestBody Genre genre){
        log.info("Delete genre: ", genreService.getById(genre.getId()));
        genreService.delete(genre);
    }
}
