package com.example.airline_ticket_system_idea.service.Impl;

import com.example.airline_ticket_system_idea.mapper.AirportViewMapper;
import com.example.airline_ticket_system_idea.pojo.CompanyRoutes;
import com.example.airline_ticket_system_idea.service.AirportViewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AirportViewServiceImpl implements AirportViewService {
@Autowired
private AirportViewMapper airportViewMapper;

    @Override
    public List<CompanyRoutes> airportRoutesList() {
        return airportViewMapper.airportRoutesList();
    }
}
