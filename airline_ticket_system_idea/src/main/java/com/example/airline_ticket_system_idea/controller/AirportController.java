package com.example.airline_ticket_system_idea.controller;

import com.example.airline_ticket_system_idea.pojo.Airport;
import com.example.airline_ticket_system_idea.pojo.Company;
import com.example.airline_ticket_system_idea.pojo.Result;
import com.example.airline_ticket_system_idea.service.AirportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(origins = "*", maxAge = 3600)
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
    @PostMapping("login")
    public Result login(String email,String password){
        Airport airport=airportService.getAirportByEmail(email);
        if(airport==null){
            return Result.error("邮箱不存在");
        }
        if(password.equals(airport.getPassword())){
            return Result.success();
        }
        return Result.error("密码错误");
    }
}

