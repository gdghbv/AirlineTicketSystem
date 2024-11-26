package com.example.airline_ticket_system_idea.controller;

import com.example.airline_ticket_system_idea.pojo.Airport;
import com.example.airline_ticket_system_idea.pojo.Result;
import com.example.airline_ticket_system_idea.service.AirportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/airport")
public class AirportController {
    @Autowired
    private AirportService airportService;

    @PostMapping("/register")
    public Result register(String airportID,String email,String password){
        Airport airport = airportService.getAirportByEmail(email);
        if(airport== null){
            airportService.register(airportID,email,password);
            return Result.success();
        }else {
            return Result.error("邮箱已被注册");
        }
    }
}
