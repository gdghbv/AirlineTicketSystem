package com.example.airline_ticket_system_idea.pojo;

import lombok.Data;

@Data
public class AirportFlight {
    private String origin;
    private String destination;
    private String originAirportID;
    private String destinationAirportID;
    private String departureTime;
    private String aircraftID;
    private String flightID;
    private String boardingGate;
    private double price;
    private int seats;
    private String originAirportName;
    private String destinationAirportName;
    private String routeID;
}
