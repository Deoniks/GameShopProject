package com.GameShop.GameShop.domain.game;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@NoArgsConstructor
@Table(name = "description")
public class Description {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String description;


    public Description(String description) {
        this.description = description;
    }

    public Description(Long id, String description) {
        this.id = id;
        this.description = description;
    }
}
