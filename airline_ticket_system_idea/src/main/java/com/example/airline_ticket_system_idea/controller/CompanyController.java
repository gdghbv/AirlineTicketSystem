package com.example.airline_ticket_system_idea.controller;

import com.example.airline_ticket_system_idea.pojo.Company;
import com.example.airline_ticket_system_idea.pojo.Result;
import com.example.airline_ticket_system_idea.service.CompanyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/company")
public class CompanyController {
   @Autowired
    private CompanyService companyService;

   @PostMapping("register")
    public Result register(String companyID,String email,String password){
       Company company= companyService.findCompanyByEmail(email);
       System.out.println("--------------------------------------------------------------------");
       if(company==null){
           companyService.register(companyID,email,password);
           System.out.println("注册成功"+Result.success());
           return Result.success();

       }else {
           System.out.println("--------------------------------------------------------------------");
           return Result.error("邮箱已经被注册");
       }
   }
}
