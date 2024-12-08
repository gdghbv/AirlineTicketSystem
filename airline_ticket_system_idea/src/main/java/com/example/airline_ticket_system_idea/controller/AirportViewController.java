package com.example.airline_ticket_system_idea.controller;


import com.example.airline_ticket_system_idea.pojo.Airport;
import com.example.airline_ticket_system_idea.pojo.AirportAirline;
import com.example.airline_ticket_system_idea.pojo.Result;
import com.example.airline_ticket_system_idea.service.Impl.AirportServiceImpl;
import com.example.airline_ticket_system_idea.service.Impl.AirportViewServiceImpl;
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
    private AirportViewServiceImpl AirportViewServiceImpl;

        @GetMapping("/getAirportFlightInfo")
        public Result<List<AirportAirline>> getAirportView() {
            List<AirportAirline> airports = AirportViewServiceImpl.getAirlineList();
            return Result.success(airports);

}

        @PostMapping("/addAirportFlightInfo")
        public Result<String> addAirport(Airport airport) {

            return Result.success("添加成功");
        }





}
