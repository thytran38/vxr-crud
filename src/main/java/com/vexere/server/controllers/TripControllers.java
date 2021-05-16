package com.vexere.server.controllers;

import com.vexere.server.models.Trip;
import com.vexere.server.repos.TripRepository;
import com.vexere.server.response.TripResponse;
import com.vexere.server.service.TripService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.RestController;
import java.lang.Iterable;
import java.util.*;
import java.util.concurrent.atomic.AtomicReference;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class TripControllers {
public static Logger logger = LoggerFactory.getLogger(TripControllers.class);

    @Bean
    public TripService tripService() {
        return new TripService();
    }

    @Bean
    public TripRepository tripRepository1(){return new TripRepository() {
        @Override
        public List<Trip> findAll() {
            return null;
        }

        @Override
        public List<Trip> findAll(Sort sort) {
            return null;
        }

        @Override
        public List<Trip> findAllById(Iterable<Long> longs) {
            return null;
        }

        @Override
        public <S extends Trip> List<S> saveAll(Iterable<S> entities) {
            return null;
        }

        @Override
        public void flush() {

        }

        @Override
        public <S extends Trip> S saveAndFlush(S entity) {
            return null;
        }

        @Override
        public void deleteInBatch(Iterable<Trip> entities) {

        }

        @Override
        public void deleteAllInBatch() {

        }

        @Override
        public Trip getOne(Long aLong) {
            return null;
        }

        @Override
        public <S extends Trip> List<S> findAll(Example<S> example) {
            return null;
        }

        @Override
        public <S extends Trip> List<S> findAll(Example<S> example, Sort sort) {
            return null;
        }

        @Override
        public Page<Trip> findAll(Pageable pageable) {
            return null;
        }

        @Override
        public <S extends Trip> S save(S entity) {
            return null;
        }

        @Override
        public Optional<Trip> findById(Long aLong) {
            return Optional.empty();
        }

        @Override
        public boolean existsById(Long aLong) {
            return false;
        }

        @Override
        public long count() {
            return 0;
        }

        @Override
        public void deleteById(Long aLong) {

        }

        @Override
        public void delete(Trip entity) {

        }

        @Override
        public void deleteAll(Iterable<? extends Trip> entities) {

        }

        @Override
        public void deleteAll() {

        }

        @Override
        public <S extends Trip> Optional<S> findOne(Example<S> example) {
            return Optional.empty();
        }

        @Override
        public <S extends Trip> Page<S> findAll(Example<S> example, Pageable pageable) {
            return null;
        }

        @Override
        public <S extends Trip> long count(Example<S> example) {
            return 0;
        }

        @Override
        public <S extends Trip> boolean exists(Example<S> example) {
            return false;
        }
    };}

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

//    @RequestMapping(value = "/trips/", method = RequestMethod.GET)
//    public List<TripResponse> getAllTrips () {
//        List<Trip> tripList = tripService.getAllTrips();
//        List<TripResponse> tripResponseList = new ArrayList<TripResponse>();
//
//
//
//            tripList.stream().forEach(trip -> {
//                tripResponseList.add(new TripResponse(trip));
//            });
//
//        return tripResponseList;
//    }

    @RequestMapping(value = "/trips2/", method = RequestMethod.GET)
    public String getAllTrips () {
        List<Trip> tripList = tripService.getAllTrips();
        List<TripResponse> tripResponseList = new ArrayList<TripResponse>();
        AtomicReference<String> data = new AtomicReference<>("");


        tripList.stream().forEach(trip -> {
            data.updateAndGet(v -> v + new TripResponse(trip));
        });

        return data.get();
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
