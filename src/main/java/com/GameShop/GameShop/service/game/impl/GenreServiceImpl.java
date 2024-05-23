package com.GameShop.GameShop.service.game.impl;

import com.GameShop.GameShop.domain.game.Genre;
import com.GameShop.GameShop.repository.game.GenreRepository;
import com.GameShop.GameShop.service.game.GenreService;
import org.apache.coyote.BadRequestException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GenreServiceImpl implements GenreService {
    private Logger log = LoggerFactory.getLogger(GenreServiceImpl.class);

    @Autowired
    private GenreRepository genreRepository;

    @Override
    public List<Genre> getAll() {
        log.info("Find all: {}",genreRepository.findAll());
        return genreRepository.findAll();
    }

    @Override
    public void save(Genre genre) throws BadRequestException {
        genreRepository.save(genre);
        log.info("Save genre: {}",genreRepository.findById(genre.getId()));
    }

    @Override
    public void update(Long id, Genre genre) {
        if(!genreRepository.findById(id).isEmpty()){
            Genre updateGenre = genreRepository.findById(id).orElse(null);
            updateGenre.setGenre(genre.getGenre());
            genreRepository.save(genre);
            log.info("Update genre: {}",genreRepository.findById(genre.getId()));
        }
    }

    @Override
    public void delete(Genre genre) {
        log.info("Delete genre: {}", genreRepository.findById(genre.getId()));
        genreRepository.delete(genre);
    }

    @Override
    public Genre getById(Long id) {
        log.info("Find genre: {}",genreRepository.findById(id));
        return genreRepository.findById(id).orElse(null);
    }
}
