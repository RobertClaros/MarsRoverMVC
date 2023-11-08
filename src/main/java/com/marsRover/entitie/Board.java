package com.marsRover.entitie;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

@Data
@NoArgsConstructor
@Component
public class Board {

    private int maxX;
    private int maxY;

    public Board(int maxX, int maxY) {
        this.maxX = maxX;
        this.maxY = maxY;
    }
}
