package com.marsRover.service;

import com.marsRover.entitie.Obstacle;

import java.util.List;

public interface RoverService {
    String executeCommands(String commands);
    void addObstacle(Obstacle obstacle);
    List<Obstacle> getObstacles();
}
