package com.example.airline_ticket_system_idea.controller;

import com.example.airline_ticket_system_idea.pojo.CompanyAircraft;
import com.example.airline_ticket_system_idea.pojo.Result;
import com.example.airline_ticket_system_idea.service.CompanyViewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/companyView")
public class CompanyViewController {
    @Autowired
    private CompanyViewService companyViewService;

 @GetMapping("/list")
    public Result<List<CompanyAircraft>> list(){
     List<CompanyAircraft> companyAircraftList = companyViewService.list();
     return Result.success(companyAircraftList);
 }

}
