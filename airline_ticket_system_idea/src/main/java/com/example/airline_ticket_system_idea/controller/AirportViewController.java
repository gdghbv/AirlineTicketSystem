package com.example.airline_ticket_system_idea.controller;


import com.example.airline_ticket_system_idea.pojo.Airport;
import com.example.airline_ticket_system_idea.pojo.AirportAirline;
import com.example.airline_ticket_system_idea.pojo.Result;
import com.example.airline_ticket_system_idea.service.Impl.AirportServiceImpl;
import com.example.airline_ticket_system_idea.service.Impl.AirportViewServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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
        public Result<String> addAirportAirline( AirportAirline airportAirline) {
             if(AirportViewServiceImpl.findAirportAirline(airportAirline.getFlightID())!= null) {
                 return Result.error("该机场航班已存在");
             }
            AirportViewServiceImpl.addAirportAirline(airportAirline);
            return Result.success("添加成功");}

}











