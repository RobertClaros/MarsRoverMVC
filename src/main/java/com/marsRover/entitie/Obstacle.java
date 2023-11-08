package com.marsRover.entitie;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.Random;

@Data
public class Obstacle {

    private int positionX;
    private int positionY;

    public Obstacle(int x, int y) {
        this.positionX = x;
        this.positionY = y;
    }

    public static Obstacle generateRandomObstacle(int maxX, int maxY) {
        Random random = new Random();
        int x = random.nextInt(maxX + 1);
        int y = random.nextInt(maxY + 1);
        return new Obstacle(x, y);
    }

}
