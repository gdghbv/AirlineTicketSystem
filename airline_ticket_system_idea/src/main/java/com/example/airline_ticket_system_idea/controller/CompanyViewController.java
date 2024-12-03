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
     String aircraftId=companyAircraft.getAircraftID();
     if(companyViewService.findAircraftByID(aircraftId)!=null){
         return Result.error("该飞机编号已经存在");}
     companyViewService.addAircraft(companyAircraft);
     return Result.success(companyAircraft);
 }
 @PutMapping("/updateAircraft")
    public Result<CompanyAircraft> updateAircraft(@RequestBody CompanyAircraft companyAircraft){
     companyViewService.updateAircraft(companyAircraft);
     return Result.success(companyAircraft);
 }
 @DeleteMapping("/deleteAircraft/{aircraftId}")
    public Result<String> deleteAircraft(@PathVariable("aircraftId") String aircraftId){
     companyViewService.deleteAircraft(aircraftId);
     return Result.success("删除成功");
 }
 @GetMapping("/routesList")
    public Result<List<>>> routesList(){
 }


