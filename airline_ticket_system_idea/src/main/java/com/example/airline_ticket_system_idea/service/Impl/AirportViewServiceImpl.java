package com.example.airline_ticket_system_idea.service.Impl;

import com.example.airline_ticket_system_idea.mapper.AirportViewMapper;
import com.example.airline_ticket_system_idea.pojo.AirportAirline;
import com.example.airline_ticket_system_idea.service.AirportViewService;
import com.example.airline_ticket_system_idea.util.ThreadLocalUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class AirportViewServiceImpl implements AirportViewService {

    @Autowired
    private AirportViewMapper AirportViewMapper;


    @Override
    public List<AirportAirline> getAirlineList() {
        Map<String ,Object> map= ThreadLocalUtil.get();
    String airportID=(String) map.get("airportID");

        return AirportViewMapper.getAirlineList(airportID);
    }


}
