package com.marsRover.service;

import com.marsRover.entitie.Board;
import com.marsRover.entitie.Direction;
import com.marsRover.entitie.Obstacle;
import com.marsRover.entitie.Rover;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
@NoArgsConstructor
@Service
public class RoverServiceImpl implements RoverService{
    private Rover rover;
    private Board board;
    private Direction direction;
    private List<Obstacle> obstacleList = new ArrayList<>();

    public RoverServiceImpl(Rover rover, Board board) {
        this.rover = rover;
        this.board = board;
        this.direction = Direction.NORTH;
        }
    public RoverServiceImpl(Rover rover, Board board, Direction initialDirection) {
        this.rover = rover;
        this.board = board;
        this.direction = initialDirection; // Inicializar la dirección con el valor proporcionado
    }
    @Override
    public String executeCommands(String commands) {
        StringBuilder result = new StringBuilder();
        for (char command : commands.toCharArray()) {
            if (command == 'f') {
                moveForward();
            } else if (command == 'b') {
                moveBackward();
            } else if (command == 'l') {
                turnLeft();
            } else if (command == 'r') {
                turnRight();
            }

        }
        result.append("Position: ").append(rover.getX()).append(",").append(rover.getY()).append(" Direction: ").append(direction).append("\n");
        return result.toString();
    }

    @Override
    public void addObstacle(Obstacle obstacle) {
        obstacleList.add(obstacle);
    }

    @Override
    public List<Obstacle> getObstacles() {
        return obstacleList;
    }
    private void moveForward() {
        int newX = rover.getX();
        int newY = rover.getY();
        switch (direction) {
            case NORTH:
                newY = (rover.getY() + 1) % (board.getMaxY() + 1);
                break;
            case EAST:
                newX = (rover.getX() + 1) % (board.getMaxX() + 1);
                break;
            case SOUTH:
                newY = (rover.getY() - 1 + board.getMaxY() + 1) % (board.getMaxY() + 1);
                break;
            case WEST:
                newX = (rover.getX() - 1 + board.getMaxX() + 1) % (board.getMaxX() + 1);
                break;
        }
        if (!isObstacle(newX, newY)) {
            rover.setX(newX);
            rover.setY(newY);
        }
    }

    private void moveBackward() {
        int newX = rover.getX();
        int newY = rover.getY();
        switch (direction) {
            case NORTH:
                newY = (rover.getY() - 1 + board.getMaxY() + 1) % (board.getMaxY() + 1);
                break;
            case EAST:
                newX = (rover.getX() - 1 + board.getMaxX() + 1) % (board.getMaxX() + 1);
                break;
            case SOUTH:
                newY = (rover.getY() + 1) % (board.getMaxY() + 1);
                break;
            case WEST:
                newX = (rover.getX() + 1) % (board.getMaxX() + 1);
                break;
        }
        if (!isObstacle(newX, newY)) {
            rover.setX(newX);
            rover.setY(newY);
        }
    }


    private void turnLeft() {
        switch (direction) {
            case NORTH:
                direction = Direction.WEST;
                break;
            case EAST:
                direction = Direction.NORTH;
                break;
            case SOUTH:
                direction = Direction.EAST;
                break;
            case WEST:
                direction = Direction.SOUTH;
                break;
        }
    }

    private void turnRight() {
        switch (direction) {
            case NORTH:
                direction = Direction.EAST;
                break;
            case EAST:
                direction = Direction.SOUTH;
                break;
            case SOUTH:
                direction = Direction.WEST;
                break;
            case WEST:
                direction = Direction.NORTH;
                break;
        }
    }
    private boolean isObstacle(int x, int y) {
        for (Obstacle obstacle : obstacleList) {
            if (obstacle.getPositionX() == x && obstacle.getPositionY() == y) {
                return true;
            }
        }
        return false;



    }
}


