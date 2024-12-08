package com.example.airline_ticket_system_idea.mapper;

import com.example.airline_ticket_system_idea.pojo.Airport;
import com.example.airline_ticket_system_idea.pojo.AirportAirline;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface AirportViewMapper {


@Select("SELECT * FROM airport_flight_info")
    List<AirportAirline> getAirlineList(String airportID);






@Select("SELECT * FROM airport_flight_info WHERE flightID = #{flightID}")
    AirportAirline findAirportAirline(String flightID);

    @Insert("insert into airport_flight_info (origin,destination,originAirport,destinationAirport,departureTime,aircraftID,flightID) values (#{origin}, #{destination}, #{originAirport}, #{destinationAirport}, #{departureTime}, #{aircraftID}, #{flightID})")
    void addAirportAirline(AirportAirline airportAirline);
}
