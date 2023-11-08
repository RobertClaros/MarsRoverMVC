package com.marsRover.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.marsRover.entitie.Board;

@Configuration
public class MarsRoverConfig {

    @Bean
    public Board marsRoverBoard() {
        int maxX = 10;
        int maxY = 10;
        return new Board(maxX, maxY);
    }
}

