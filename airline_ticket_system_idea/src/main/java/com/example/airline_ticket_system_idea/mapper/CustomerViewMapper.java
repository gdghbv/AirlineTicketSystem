package com.example.airline_ticket_system_idea.mapper;


import com.example.airline_ticket_system_idea.pojo.AirportFlight;
import com.example.airline_ticket_system_idea.pojo.CompanyRoutes;
import com.example.airline_ticket_system_idea.pojo.Customer;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

@Mapper
public interface CustomerViewMapper {

    @Select("Select * from airport_flight_info")
    List<AirportFlight> getFlightList();

@Select("Select * from company_routes_info where routeID = #{routeID}")
    CompanyRoutes getCompanyRoutes(String routeID);

@Insert("Insert into customer_ticket_info(dateTime,flightID,status,email) values(#{dateTime},#{flightID},#{status},#{email})")
    void orderFlight(AirportFlight airportFlight);
@Update("UPDATE airport_flight_info SET seatCount= #{seatCount} WHERE flightID = #{flightID}")
    void updateFlightSeatCount(AirportFlight airportFlight);
@Select("SELECT * FROM airport_flight_info WHERE flightID = #{flightID}")
    AirportFlight getFlight(String flightID);
@Select("SELECT * FROM customer_info WHERE email = #{email}")
    Customer getCustomerInfo(String email);
}
