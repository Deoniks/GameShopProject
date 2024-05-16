package com.GameShop.GameShop.repository.game;

import com.GameShop.GameShop.domain.game.Genre;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GenreRepository extends JpaRepository<Genre,Long> {

}
