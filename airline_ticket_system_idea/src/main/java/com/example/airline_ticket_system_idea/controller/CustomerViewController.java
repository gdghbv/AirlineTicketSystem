package com.example.airline_ticket_system_idea.controller;

import com.example.airline_ticket_system_idea.pojo.AirportFlight;
import com.example.airline_ticket_system_idea.pojo.Result;
import com.example.airline_ticket_system_idea.service.CustomerViewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/customerView")
public class CustomerViewController {
    @Autowired
    private CustomerViewService customerViewService;

    @GetMapping("/flightList")
    public Result<List<AirportFlight>> getFlightList() {
       List<AirportFlight> flightList = customerViewService.getFlightList();
        return Result.success(flightList);
    }
    @PostMapping("/orderFlight")
    public Result<String> orderFlight(@RequestBody AirportFlight airportFlight){
        customerViewService.orderFlight(airportFlight);
        return Result.success("订购成功");
    }
}
