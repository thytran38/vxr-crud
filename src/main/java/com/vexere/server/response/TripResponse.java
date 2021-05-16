//package com.vexere.server.response;
//
//import com.fasterxml.jackson.annotation.JsonProperty;
//
//import com.vexere.server.models.Trip;
//import lombok.Getter;
//import lombok.Setter;
//
//@Setter
//@Getter
//public class TripResponse {
//
//    private long id;
//
////    @JsonProperty("tripName")
//    private String tripName;
//
//    private String departLoca;
//    private String arrivalLoca;
//
//    private long price;
//
//    public TripResponse (Trip trip) {
//        this.id = trip.getTripId();
//        this.tripName = trip.getTripName();
//        this.departLoca = trip.getDepartLoca();
//        this.arrivalLoca = trip.getDepartLoca();
//        this.price = trip.getPrice();
//    }
//
//}