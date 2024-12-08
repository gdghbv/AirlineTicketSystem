package com.example.airline_ticket_system_idea.controller;


import com.example.airline_ticket_system_idea.pojo.Airport;
import com.example.airline_ticket_system_idea.pojo.AirportFlight;
import com.example.airline_ticket_system_idea.pojo.Customer;
import com.example.airline_ticket_system_idea.pojo.Result;
import com.example.airline_ticket_system_idea.service.AirportViewService;
import com.example.airline_ticket_system_idea.util.ThreadLocalUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/airportView")
public class AirportViewController {
    @Autowired
    private AirportViewService airportViewService;

    @GetMapping("/flightList")
    public Result<List<AirportFlight>> getFlight(@RequestBody AirportFlight airportFlight) {
        List<AirportFlight> flightList = airportViewService.getFlight(airportFlight);
        return Result.success(flightList);
    }

    @PostMapping("/addFlight")
    public Result<AirportFlight> addFlight(@RequestBody AirportFlight airportFlight) {
        if(airportViewService.getRouteByID(airportFlight.getRouteID())==null){
            return Result.error("该航线不存在");
        }
        if(airportViewService.getFlightByID(airportFlight.getFlightID())!= null){
            return Result.error("该机场已存在相同航班");
        }

      airportViewService.addFlight(airportFlight);
        return Result.success(airportFlight);
    }
    @PutMapping("/updateFlight")
    public Result<AirportFlight> updateFlight(@RequestBody AirportFlight airportFlight){
        airportViewService.updateFlight(airportFlight);
        return Result.success(airportFlight);

    }
    @PutMapping("/deleteFlight")
    public Result<String> deleteFlight(@RequestBody AirportFlight airportFlight){
        if(airportViewService.getFlightByID(airportFlight.getFlightID()) == null){
            return Result.error("该机场不存在该航班");
        }
        airportViewService.deleteFlight(airportFlight);
        return Result.success("删除成功");
}
  @PutMapping("/delayAirport")
    public Result<String> delayAirport(@RequestBody AirportFlight airportFlight){
        airportViewService.delayAirport(airportFlight);
        return Result.success("航班延误设置成功");
  }
  @GetMapping("/customerList")
public Result<List<Customer>> getCustomerList(){
        List<Customer> customerList = airportViewService.getCustomerList();
        return Result.success(customerList);
  }
  @PutMapping("/updateCustomer")
    public Result<Customer> updateCustomer(@RequestBody Customer customer){
        airportViewService.updateCustomer(customer);
        return Result.success(customer);
    }
    @DeleteMapping("/deleteCustomer")
    public Result<String> deleteCustomer(@RequestBody Customer customer){
        airportViewService.deleteCustomer(customer);
        return Result.success("删除成功");
}
@GetMapping("airportInfo")
        public Result<Airport> getAirportInfo(){
            Map<String,Object> map = ThreadLocalUtil.get();
            String airportID=(String) map.get("airportID");
            Airport airport = airportViewService.getAirportInfo(airportID);
            return Result.success(airport);
    }

}










