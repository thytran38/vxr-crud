package com.vexere.server.service;

import com.vexere.server.models.Trip;
import com.vexere.server.repos.TripRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Component
public class TripService {

    @Autowired
    TripRepository tripRepository;

    public List<Trip> getAllTrips () {
        return tripRepository.findAll();
    }
}