package com.example.airline_ticket_system_idea.mapper;


import com.example.airline_ticket_system_idea.pojo.AirportFlight;
import com.example.airline_ticket_system_idea.pojo.CompanyRoutes;
import com.example.airline_ticket_system_idea.pojo.Customer;
import com.example.airline_ticket_system_idea.pojo.CustomerTicketInfo;
import org.apache.ibatis.annotations.*;

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

    @Select("SELECT * FROM customer_ticket_info WHERE email = #{email}")
    List<CustomerTicketInfo> getBillList(String email);

    @Select("SELECT * FROM airport_flight_info WHERE flightID = #{flightID}")
    AirportFlight getCustomerFlight(String flightID);

    @Update("UPDATE customer_ticket_info SET status = '已退款' WHERE ticketID = #{ticketID}")
    void billRetreat(String ticketID);
@Select("SELECT * FROM customer_ticket_info WHERE ticketID = #{ticketID}")
    CustomerTicketInfo getCustomerTicketInfo(String ticketID);
}
