package com.vexere.server.controllers;

import com.vexere.server.models.Trip;
import com.vexere.server.repos.TripRepository;
import com.vexere.server.response.TripResponse;
import com.vexere.server.service.TripService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.RestController;
import java.lang.Iterable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.validation.Valid;
import javax.xml.ws.Response;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/api")
public class TripControllers {
public static Logger logger = LoggerFactory.getLogger(TripControllers.class);

    @Autowired
    private TripService tripService;

//    @CrossOrigin
//    @GetMapping
//    public String getAllTrips(){return "You are here.";}

//    @CrossOrigin
//    @GetMapping("/trips")
//    public List<Trip> getAll() {
//        return tripRepository.findAll();
//    }

    @RequestMapping(value = "/trips/", method = RequestMethod.GET)
    public List<TripResponse> getAllTrips () {
        List<Trip> tripList = tripService.getAllTrips();
        List<TripResponse> tripResponseList = new ArrayList<TripResponse>();


            tripList.stream().forEach(trip -> {
                tripResponseList.add(new TripResponse(trip));
            });

        return tripResponseList;
    }

//
//    @CrossOrigin
//    @GetMapping("/trips/{id}")
//    public ResponseEntity<Trip> getTripById(@PathVariable(value = "id") Long tripID)
//            throws ResourceNotFoundException {
//        Trip trip = tripRepository.findById(tripID)
//                .orElseThrow(() -> new ResourceNotFoundException("Trip not found for this id :: " + tripID));
//        return ResponseEntity.ok().body(trip);
//    }
//
//    @CrossOrigin
//    @PostMapping("/trips")
//    public Trip createTrip(@Valid @RequestBody Trip trip) {
//        return tripRepository.save(trip);
//    }
//
//    @CrossOrigin
//    @PostMapping("bulkcreate")
//    public Iterable<Trip> createSeveralTrips(@Valid @RequestBody Iterable<Trip> trips){return tripRepository.saveAll(trips);}
//
//    @CrossOrigin
//    @PutMapping("/trips/{id}")
//    public ResponseEntity<Trip> updateTripArrivalTime(@PathVariable(value = "id") Long tripID,
//                                                      @Valid @RequestBody Trip tripDetails) throws ResourceNotFoundException {
//        Trip trip = tripRepository.findById(tripID)
//                .orElseThrow(() -> new ResourceNotFoundException("Trip not found for this id :: " + tripID));
//
//        trip.setArrivalDatetime(tripDetails.getArrivalDatetime());
//        final Trip updatedTrip = tripRepository.save(trip);
//        return ResponseEntity.ok(trip);
//    }
//
//    @CrossOrigin
//    @PutMapping("/trips/{id}")
//    public ResponseEntity<Trip> updateTripStartTime(@PathVariable(value = "id") Long tripID,
//                                                    @Valid @RequestBody Trip tripDetails) throws ResourceNotFoundException {
//        Trip trip = tripRepository.findById(tripID)
//                .orElseThrow(() -> new ResourceNotFoundException("Trip not found for this id :: " + tripID));
//
//        trip.setStartDatetime(tripDetails.getStartDatetime());
//        final Trip updatedTrip = tripRepository.save(trip);
//        return ResponseEntity.ok(trip);
//    }
//
//    @CrossOrigin
//    @PutMapping("/trips/{id}")
//    public ResponseEntity<Trip> updateTripPrice(@PathVariable(value = "id") Long tripID,
//                                                @Valid @RequestBody Trip tripDetails) throws ResourceNotFoundException {
//        Trip trip = tripRepository.findById(tripID)
//                .orElseThrow(() -> new ResourceNotFoundException("Trip not found for this id :: " + tripID));
//
//        trip.setStartDatetime(tripDetails.getStartDatetime());
//        final Trip updatedTrip = tripRepository.save(trip);
//        return ResponseEntity.ok(updatedTrip);
//    }
//
//    @CrossOrigin
//    @DeleteMapping("/trips/{id}")
//    public Map<String, Boolean> deleteTrip(@PathVariable(value="id") Long tripID) throws ResourceNotFoundException
//    {
//        Trip trip = tripRepository.findById(tripID)
//                .orElseThrow(() -> new ResourceNotFoundException("Trip not found for this id :: " + tripID));
//
//        tripRepository.delete(trip);
//        Map<String, Boolean> response = new HashMap<>();
//        response.put("Trip deleted", Boolean.TRUE);
//        return response;
//    }

}
