package com.example.airline_ticket_system_idea.mapper;

import com.example.airline_ticket_system_idea.pojo.*;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface AirportViewMapper {




    @Select("SELECT * FROM airport_flight_info WHERE airportID= #{airportID}")
    List<AirportFlight> getFlightList(String airportID);


@Select("SELECT * FROM company_routes_info WHERE routeID= #{routeID}")
    CompanyRoutes getCompanyRoute(String routeId);
@Insert("INSERT INTO company_flight_info (airportID,routeID,flightID,departureTime,boardingGate,price,delay) VALUES (#{airportID},#{routeID},#{flightID},#{departureTime},#{boardingGate},#{price},'否')")
    void addFlight(AirportFlight airportFlight);
@Update("UPDATE company_flight_info SET airportID= #{airportID},routeID= #{routeID},flightID= #{flightID},departureTime= #{departureTime},boardingGate= #{boardingGate},price= #{price} ")
    void updateFlight(AirportFlight airportFlight);

@Delete("DELETE FROM company_flight_info WHERE flightID= #{flightID}")
    void deleteFlight(String flightID);

@Update("UPDATE company_flight_info SET delay= '是' WHERE flightID= #{flightID}")
    void delayFlight(String flightID,String delayTime);
@Select("SELECT * FROM aircraft_info Where airportIDD= #{airportID}")
   List<AirportAircraft> getAircraftList(String airportID);

@Select("SELECT aircraftType FROM company_aircraft_info WHERE aircraftID= #{aircraftID}")
    String getAircraftType(String aircraftID);
@Select("SELECT airportName FROM airport_info WHERE airportID= #{airportID}")
    String getAirportName(String airportID);

@Insert("INSERT INTO company_aircraft_info (aircraftID,airportID,status) VALUES ( #{aircraftID},#{airportID},#{status})")
    void addAircraft(AirportAircraft airportAircraft);
@Delete("DELETE FROM company_aircraft_info WHERE aircraftID= #{aircraftID}")
    void deleteAircraft(String aircraftID);
@Update("UPDATE company_aircraft_info SET aircraftID= #{aircraftID},airportID= #{airportID},status= #{status}")
    void updateAircraft(AirportAircraft airportAircraft);
}
