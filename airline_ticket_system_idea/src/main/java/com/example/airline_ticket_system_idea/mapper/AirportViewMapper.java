package com.example.airline_ticket_system_idea.mapper;

import com.example.airline_ticket_system_idea.pojo.Airport;
import com.example.airline_ticket_system_idea.pojo.AirportFlight;
import com.example.airline_ticket_system_idea.pojo.CompanyRoutes;
import com.example.airline_ticket_system_idea.pojo.Customer;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface AirportViewMapper {

    @Select("SELECT * FROM airport_flight_info WHERE originAirportID = #{originAirportID}")
    List<AirportFlight> getFlight(@Param("originAirportID") String originAirportID);

@Select("SELECT airportName FROM airport_info WHERE airportID = #{airportID}")
String getAirportNameByID(@Param("airportID") String originAirportID);

@Select("SELECT * FROM airport_flight_info WHERE flightID = #{flightID}")
    AirportFlight getFlightByID(String flightID);

@Insert("INSERT INTO airport_flight_info (origin,destination,originAirportID,destinationAirportID,aircraftID,flightID,departureTime,boardingGate,price,seats) VALUES (#{origin},#{destination},#{originAirportID},#{destinationAirportID},#{aircraftID},#{flightID},#{departureTime},#{boardingGate},#{price},#{seats}) ")
    void addFlight(AirportFlight airportFlight);

   @Update("UPDATE airport_flight_info SET origin = #{origin},destination = #{destination},originAirportID = #{originAirportID},destinationAirportID = #{destinationAirportID},aircraftID = #{aircraftID},flightID = #{flightID},departureTime = #{departureTime},boardingGate = #{boardingGate},price = #{price},seats = #{seats} WHERE flightID = #{flightID}")
    void updateFlight(AirportFlight airportFlight);

   @Delete("DELETE FROM airport_flight_info WHERE flightID = #{flightID}")
    void deleteFlight(AirportFlight airportFlight);

@Update("UPDATE airport_flight_info SET departureTime = #{departureTime} WHERE flightID = #{flightID}")
    void delayAirport(AirportFlight airportFlight);
@Select("SELECT * FROM customer_info")
    List<Customer> getCustomerList();

@Update("UPDATE customer_info SET name = #{name},email = #{email},phone = #{phone},address = #{address} WHERE customerID = #{customerID}")
    void updateCustomer(Customer customer);

@Delete("DELETE FROM customer_info WHERE customerID = #{customerID}")
    void deleteCustomer(Customer customer);

@Select("SELECT * FROM airport_info WHERE airportID = #{airportID}")
    Airport getAirportInfoByID(String airportID);

@Select("SELECT * FROM company_routes WHERE routeID = #{routeID}")
    CompanyRoutes getRouteByID(String routeID);
}