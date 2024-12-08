package com.example.airline_ticket_system_idea.service;

import com.example.airline_ticket_system_idea.pojo.Airport;
import com.example.airline_ticket_system_idea.pojo.AirportFlight;
import com.example.airline_ticket_system_idea.pojo.CompanyRoutes;
import com.example.airline_ticket_system_idea.pojo.Customer;

import java.util.List;

public interface AirportViewService {
    List<AirportFlight> getFlight(AirportFlight airportFlight);

    AirportFlight getFlightByID(String originAirportID);

    void addFlight(AirportFlight airportFlight);

    void updateFlight(AirportFlight airportFlight);

    void deleteFlight(AirportFlight airportFlight);

    void delayAirport(AirportFlight airportFlight);

    List<Customer> getCustomerList();

    void updateCustomer(Customer customer);

    void deleteCustomer(Customer customer);

    Airport getAirportInfo(String airportID);

    CompanyRoutes getRouteByID(String routeID);
}
