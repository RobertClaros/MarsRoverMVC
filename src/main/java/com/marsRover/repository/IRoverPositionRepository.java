package com.marsRover.repository;

import com.marsRover.entitie.RoverPosition;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IRoverPositionRepository extends JpaRepository<RoverPosition,Long> {
}
