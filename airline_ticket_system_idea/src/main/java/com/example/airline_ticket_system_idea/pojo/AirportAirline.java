package com.example.airline_ticket_system_idea.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Time;
import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AirportAirline {
    private String origin;
    private String destination;
    private String originAirport;
    private String destinationAirport;
    private String flightID;
    private String aircraftID;
    private LocalDateTime departureTime;





}
