package com.marsRover.entitie;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

@Data
@NoArgsConstructor
@Component
public class Rover {

    private Direction direction;
    private int x;
    private int y;

    public Rover(Direction direction, int x, int y) {
        this.direction = direction;
        this.x = x;
        this.y = y;
    }
}

