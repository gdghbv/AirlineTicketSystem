package com.example.airline_ticket_system_idea.controller;

import com.example.airline_ticket_system_idea.pojo.AirportFlights;
import com.example.airline_ticket_system_idea.pojo.CompanyRoutes;
import com.example.airline_ticket_system_idea.pojo.Result;
import com.example.airline_ticket_system_idea.service.AirportViewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/airportView")
public class AirportViewController {
    @Autowired
    private AirportViewService airportViewService;

    @GetMapping("/airportRoutes")
    public Result<List<CompanyRoutes>> list(){
    List<CompanyRoutes> list=airportViewService.airportRoutesList();
    return Result.success(list);
    }

}
