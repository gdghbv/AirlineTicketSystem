package com.example.airline_ticket_system_idea.service.Impl;

import com.example.airline_ticket_system_idea.mapper.CustomerViewMapper;
import com.example.airline_ticket_system_idea.pojo.AirportFlight;
import com.example.airline_ticket_system_idea.pojo.CompanyRoutes;
import com.example.airline_ticket_system_idea.service.CustomerViewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerViewServiceImpl implements CustomerViewService {
    @Autowired
    private CustomerViewMapper customerViewMapper;
    @Override
    public List<AirportFlight> getFlightList() {
        List<AirportFlight> airportFlights = customerViewMapper.getFlightList();
        for(AirportFlight airportFlight: airportFlights){
String routeId=airportFlight.getRouteID();
            CompanyRoutes companyRoutes=customerViewMapper.getCompanyRoutes(routeId);

                airportFlight.setOrigin(companyRoutes.getOrigin());
                airportFlight.setDestination(companyRoutes.getDestination());
                airportFlight.setOriginAirport(companyRoutes.getOriginAirport());
                airportFlight.setDestinationAirport(companyRoutes.getDestinationAirport());
                airportFlight.setCompanyID(companyRoutes.getCompanyID());
                airportFlight.setAircraftID(companyRoutes.getAircraftID());

        }
        return airportFlights;
    }
}
