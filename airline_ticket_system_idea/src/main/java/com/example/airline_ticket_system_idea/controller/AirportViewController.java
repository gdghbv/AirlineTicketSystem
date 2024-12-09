package com.example.airline_ticket_system_idea.controller;


import com.example.airline_ticket_system_idea.pojo.AirportAircraft;
import com.example.airline_ticket_system_idea.pojo.AirportFlight;
import com.example.airline_ticket_system_idea.pojo.Result;
import com.example.airline_ticket_system_idea.service.AirportViewService;
import org.apache.ibatis.annotations.Delete;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/airportView")
public class AirportViewController {
    @Autowired
    private AirportViewService airportViewService;

    @GetMapping("/flightList")
    public Result<List<AirportFlight>> getFlightList() {
        List<AirportFlight> flightList = airportViewService.getFlightList();
        return Result.success(flightList);

    }
    @PostMapping("/addFlight")
    public Result<String> addFlight(@RequestBody AirportFlight airportFlight){
        airportViewService.addFlight(airportFlight);
        return Result.success("添加成功");
    }
    @PutMapping("/updateFlight")
    public Result<String> updateFlight(@RequestBody AirportFlight airportFlight){
        airportViewService.updateFlight(airportFlight);
        return Result.success("更新成功");
    }
    @DeleteMapping("/deleteFlight/{id}")
    public Result<String> deleteFlight(String flightID){
        airportViewService.deleteFlight(flightID);
        return Result.success("删除成功");
    }
    @PutMapping("/delayFlight/{id}")
  public Result<String> delayFlight(String flightID,String delayTime){
      airportViewService.delayFlight(flightID,delayTime);
        return Result.success("延误成功");
    }
    @GetMapping("/aircraftList")
    public Result<List<AirportAircraft>> getAircraftList() {
       List<AirportAircraft>    aircraftList = airportViewService.getAircraftList();
        return Result.success(aircraftList);

    }
    @PostMapping("/addAircraft")
    public Result<String> addAircraft(@RequestBody AirportAircraft airportAircraft){

        airportViewService.addAircraft(airportAircraft);
        return Result.success("添加成功");
    }
    @DeleteMapping("/deleteAircraft")
    public Result<String> deleteAircraft(String aircraftID) {
    airportViewService.deleteAircraft(aircraftID);
    return Result.success("删除成功");
    }
    @PutMapping("/updateAircraft")
    public Result<String> updateAircraft(@RequestBody AirportAircraft airportAircraft){
        airportViewService.updateAircraft(airportAircraft);
        return Result.success("更新成功");
    }}












