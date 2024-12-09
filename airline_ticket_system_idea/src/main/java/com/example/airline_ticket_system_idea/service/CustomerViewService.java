package com.example.airline_ticket_system_idea.service;

import com.example.airline_ticket_system_idea.pojo.AirportFlight;
import com.example.airline_ticket_system_idea.pojo.Customer;

import java.util.List;

public interface CustomerViewService {

    List<AirportFlight> getFlightList();

    void orderFlight(AirportFlight airportFlight);
}
