package com.vexere.server.service;

import com.vexere.server.models.Trip;
import com.vexere.server.repos.TripRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@Component
public class TripService {

    @Autowired
    TripRepository tripRepository;

    public List<Trip> getAllTrips () {
        return tripRepository.findAll();
    }
    public Optional<Trip> findTripById(@PathVariable(value = "id") Integer tripID){return tripRepository.findById(tripID);}
    public Trip createTrip(@Valid @RequestBody Trip trip){return tripRepository.save(trip);}
    public Iterable<Trip> createBulkTrips(@Valid @RequestBody Iterable<Trip> trips){return tripRepository.saveAll(trips);}
}