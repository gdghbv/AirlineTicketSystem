package com.example.airline_ticket_system_idea.pojo;

import lombok.Data;

@Data
public class AirportFlight {
  //  这是航线相关信息
    private String routeID;
    private String aircraftID;
    private String origin;
    private String destination;
    private String originAirport;
    private String destinationAirport;
    private String companyID;
    //这是航班在航线基础上添加的信息
    private String flightID;
    private String airportID;;
    private String departureTime;
    private String boardingGate;
    private String price;
    private String delay;
    private int seatCount;

}
