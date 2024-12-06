package com.example.airline_ticket_system_idea.mapper;

import com.example.airline_ticket_system_idea.pojo.CompanyRoutes;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface AirportViewMapper {
    @Select("SELECT * FROM company_routes")
    List<CompanyRoutes> airportRoutesList();
}
