package com.vexere.server.controllers;

import com.vexere.server.models.Trip;
import com.vexere.server.repos.TripRepository;
//import com.vexere.server.response.TripResponse;
import com.vexere.server.service.TripService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.lang.Iterable;
import java.util.*;
import java.util.concurrent.atomic.AtomicReference;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
public class TripControllers {
    public static Logger logger = LoggerFactory.getLogger(TripControllers.class);
    @Autowired
    private TripService tripService;

    @Bean
    public TripService tripService() {
        return new TripService();
    }

    @RequestMapping(value = "/allTrips", method = RequestMethod.GET)
    public ArrayList<HashMap<String, String>> endPoint() {
        List<Trip> listTripsOrigin = tripService.getAllTrips();
        ArrayList<HashMap<String, String>> dataMap = new ArrayList<HashMap<String, String>>();
        List<Trip> listTrips = new ArrayList<>();
        Iterator<Trip> iterator = listTripsOrigin.iterator();
        // Convert List<Trip> to ArrayList<Trip>
        while (iterator.hasNext()) {
            listTrips.add(iterator.next());
        }

        for (int i = 0; i < listTrips.size(); i++) {
            HashMap<String, String> tmp = new HashMap<String, String>();
            tmp.put("tripID", String.valueOf(listTrips.get(i).tripId));
            tmp.put("tripName", String.valueOf(listTrips.get(i).tripName));
            tmp.put("departLocation", String.valueOf(listTrips.get(i).departLoca));
            tmp.put("desLoca", String.valueOf(listTrips.get(i).desLoca));
            tmp.put("departStation", String.valueOf(listTrips.get(i).departStation));
            tmp.put("busID", String.valueOf(listTrips.get(i).busId));
            tmp.put("busBrand", String.valueOf(listTrips.get(i).busBrand));
            tmp.put("seatAvailable", String.valueOf(listTrips.get(i).seatAvailable));
            tmp.put("price", String.valueOf(listTrips.get(i).price));
            tmp.put("startDatetime", String.valueOf(listTrips.get(i).startDatetime));
            tmp.put("arrivalDatetime", String.valueOf(listTrips.get(i).arrivalDatetime));

            dataMap.add(tmp);
        }

        return dataMap;

    }
//    public List<Trip> getAllTrips(){
//        return tripService.getAllTrips();
//    }

    @CrossOrigin
    @GetMapping("/trips/{id}")
    public ResponseEntity<Trip> getTripById(@PathVariable(value = "id") Integer tripID)
            throws ResourceNotFoundException {
        Trip trip = tripService.findTripById(tripID)
                .orElseThrow(() -> new ResourceNotFoundException("Trip not found for this id :: " + tripID));
        return ResponseEntity.ok().body(trip);
    }

    //
    @CrossOrigin
    @PostMapping("/trips/new")
    public Trip createTrip(@Valid @RequestBody Trip trip) {
        return tripService.createTrip(trip);
    }

    //
    @CrossOrigin
    @PostMapping("/trips/bulkcreate")
    public Iterable<Trip> createSeveralTrips(@Valid @RequestBody Iterable<Trip> trips) {
        return tripService.createBulkTrips(trips);
    }
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

    @CrossOrigin
    @PutMapping("/trips/{id}")
    public ResponseEntity<Trip> updateTripSeatNumber(@PathVariable(value = "id") Integer tripID,
                                                     @Valid @RequestBody Trip tripDetails) throws ResourceNotFoundException {
        Trip trip = tripService.findTripById(tripID)
                .orElseThrow(() -> new ResourceNotFoundException("Trip not found for this id :: " + tripID));

        trip.setSeatAvailable(tripDetails.getSeatAvailable());
        final Trip updatedTrip = tripService.createTrip(trip);
        return ResponseEntity.ok(updatedTrip);
    }



}
