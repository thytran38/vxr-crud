package com.vexere.server.repos;

import com.vexere.server.models.Trip;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.util.List;

@Repository
@Component
public interface TripRepository extends JpaRepository<Trip, Integer>{

}