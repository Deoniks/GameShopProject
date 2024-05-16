package com.GameShop.GameShop.repository.game;

import com.GameShop.GameShop.domain.game.Description;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DescriptionRepository extends JpaRepository<Description,Long> {
}
