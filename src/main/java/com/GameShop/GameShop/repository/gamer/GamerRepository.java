package com.GameShop.GameShop.repository.gamer;

import com.GameShop.GameShop.domain.gamer.Gamer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GamerRepository extends JpaRepository<Gamer,Long> {
}
