package com.example.airline_ticket_system_idea.mapper;

import com.example.airline_ticket_system_idea.pojo.Airport;
import com.example.airline_ticket_system_idea.pojo.AirportAirline;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface AirportViewMapper {


@Select("SELECT * FROM airport_flight_info")
    List<AirportAirline> getAirlineList(String airportID);
}
