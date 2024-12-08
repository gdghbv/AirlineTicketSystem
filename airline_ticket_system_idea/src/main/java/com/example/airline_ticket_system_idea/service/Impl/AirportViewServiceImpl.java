package com.example.airline_ticket_system_idea.service.Impl;

import com.example.airline_ticket_system_idea.mapper.AirportViewMapper;
import com.example.airline_ticket_system_idea.pojo.Airport;
import com.example.airline_ticket_system_idea.pojo.AirportFlight;
import com.example.airline_ticket_system_idea.pojo.CompanyRoutes;
import com.example.airline_ticket_system_idea.pojo.Customer;
import com.example.airline_ticket_system_idea.service.AirportViewService;
import com.example.airline_ticket_system_idea.util.ThreadLocalUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class AirportViewServiceImpl implements AirportViewService {

    @Autowired
    private AirportViewMapper airportViewMapper;

    @Override
    public List<AirportFlight> getFlight(AirportFlight airportFlight) {
        Map<String,Object> map= ThreadLocalUtil.get();
        String originAirportID=(String) map.get("airportID");
List<AirportFlight> airportFlights=airportViewMapper.getFlight(originAirportID);
//根据机场的ID，查询出起始机场和目的机场的名称
for(AirportFlight flight:airportFlights){
    String originAirportName=airportViewMapper.getAirportNameByID(flight.getOriginAirportID());
    String destinationAirportName=airportViewMapper.getAirportNameByID(flight.getDestinationAirportID());
    flight.setOriginAirportName(originAirportName);
    flight.setDestinationAirportName(destinationAirportName);
}
return airportFlights;
    }

    @Override
    public AirportFlight getFlightByID(String flightID) {
        return airportViewMapper.getFlightByID(flightID);
    }

    @Override
    public void addFlight(AirportFlight airportFlight) {
        airportViewMapper.addFlight(airportFlight);
    }

    @Override
    public void updateFlight(AirportFlight airportFlight) {
        airportViewMapper.updateFlight(airportFlight);
    }

    @Override
    public void deleteFlight(AirportFlight airportFlight) {
        airportViewMapper.deleteFlight(airportFlight);
    }

    @Override
    public void delayAirport(AirportFlight airportFlight) {
        airportViewMapper.delayAirport(airportFlight);
    }

    @Override
    public List<Customer> getCustomerList() {
        return airportViewMapper.getCustomerList();
    }

    @Override
    public void updateCustomer(Customer customer) {
        airportViewMapper.updateCustomer(customer);
    }

    @Override
    public void deleteCustomer(Customer customer) {
        airportViewMapper.deleteCustomer(customer);
    }

    @Override
    public Airport getAirportInfo(String airportID) {
        return airportViewMapper.getAirportInfoByID(airportID);
    }

    @Override
    public CompanyRoutes getRouteByID(String routeID) {
        return airportViewMapper.getRouteByID(routeID);
    }
}
