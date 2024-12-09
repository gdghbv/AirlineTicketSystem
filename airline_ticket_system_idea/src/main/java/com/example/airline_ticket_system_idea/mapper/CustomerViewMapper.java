package com.example.airline_ticket_system_idea.mapper;


import com.example.airline_ticket_system_idea.pojo.AirportFlight;
import com.example.airline_ticket_system_idea.pojo.CompanyRoutes;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface CustomerViewMapper {

    @Select("Select * from airport_flight_info")
    List<AirportFlight> getFlightList();

@Select("Select * from company_routes_info where route_id = #{routeId}")
    CompanyRoutes getCompanyRoutes(String routeId);
}
