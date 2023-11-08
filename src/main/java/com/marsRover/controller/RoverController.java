package com.marsRover.controller;
import com.marsRover.entitie.*;
import com.marsRover.repository.IRoverPositionRepository;
import com.marsRover.service.RoverService;
import com.marsRover.service.RoverServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/rover")
public class RoverController {

    @Autowired
    private RoverService roverService;
    @Autowired
    public IRoverPositionRepository roverPositionRepository;
    private Rover rover;
    private Board board;


    @GetMapping("/start")
    public String showRoverForm(Model model) {
        model.addAttribute("roverRequest", new RoverRequest());
        return "roverForm";
    }

    @PostMapping("/start")
    public String startRover(RoverRequest roverRequest, Model model) {

        int maxX = roverRequest.getMaxX();
        int maxY = roverRequest.getMaxY();
        String commands = roverRequest.getCommands();

        rover = new Rover(Direction.NORTH,0, 0);
        board = new Board(maxX, maxY);
        RoverServiceImpl roverService = new RoverServiceImpl(rover, board, Direction.NORTH);

        Obstacle obstacle1 = Obstacle.generateRandomObstacle(maxX, maxY);
        Obstacle obstacle2 = Obstacle.generateRandomObstacle(maxX, maxY);
        roverService.addObstacle(obstacle1);
        roverService.addObstacle(obstacle2);
        int obstacleX1 = obstacle1.getPositionX();
        int obstacleY1 = obstacle1.getPositionY();
        int obstacleX2 = obstacle1.getPositionX();
        int obstacleY2 = obstacle1.getPositionY();

        String result = roverService.executeCommands(commands);
        int positionX = rover.getX();
        int positionY = rover.getY();
        Direction direction = rover.getDirection();
        RoverPosition roverPosition = new RoverPosition(positionX, positionY, direction,
                commands, obstacleX1, obstacleY1, obstacleX2, obstacleY2, maxX, maxY);
        roverPositionRepository.save(roverPosition);

        model.addAttribute("roverResult", result);
        model.addAttribute("positionX", positionX);
        model.addAttribute("positionY", positionY);
        model.addAttribute("direction", direction);
        model.addAttribute("obstacleX1", obstacleX1);
        model.addAttribute("obstacleY1", obstacleY1);
        model.addAttribute("obstacleX2", obstacleX2);
        model.addAttribute("obstacleY2", obstacleY2);
        model.addAttribute("maxX", maxX);
        model.addAttribute("maxY", maxY);
        model.addAttribute("commands", commands);
        return "roverResult";
    }
}
