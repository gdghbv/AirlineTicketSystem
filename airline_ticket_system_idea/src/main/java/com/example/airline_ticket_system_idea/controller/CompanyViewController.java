package com.example.airline_ticket_system_idea.controller;

import com.example.airline_ticket_system_idea.pojo.Company;
import com.example.airline_ticket_system_idea.pojo.CompanyAircraft;
import com.example.airline_ticket_system_idea.pojo.Result;
import com.example.airline_ticket_system_idea.service.CompanyViewService;
import com.example.airline_ticket_system_idea.util.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;


@RestController
@RequestMapping("/companyView")
public class CompanyViewController {
    @Autowired
    private CompanyViewService companyViewService;

 @GetMapping("/aircraftList")
    public Result<List<CompanyAircraft>> list(){
     List<CompanyAircraft> caList= companyViewService.list();
     return Result.success(caList);
 }
@PostMapping("/addAircraft")
    public Result<CompanyAircraft> addAircraft(@RequestBody CompanyAircraft companyAircraft){
     companyViewService.addAircraft(companyAircraft);
     return Result.success(companyAircraft);
 }
}

