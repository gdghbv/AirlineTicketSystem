package com.example.airline_ticket_system_idea.controller;

import com.example.airline_ticket_system_idea.pojo.Company;
import com.example.airline_ticket_system_idea.pojo.Result;
import com.example.airline_ticket_system_idea.service.CompanyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/company")
public class CompanyController {
   @Autowired
    private CompanyService companyService;

   @PostMapping("register")
    public Result register(String companyID,String email,String password){
       Company company= companyService.findCompanyByEmail(email);
       if(company==null){
           companyService.register(companyID,email,password);
           return Result.success();

       }else {

           return Result.error("邮箱已经被注册");
       }
   }
   @PostMapping("login")
    public Result login(String email,String password){
       Company company=companyService.findCompanyByEmail(email);
       if(company==null){
            return Result.error("邮箱不存在");
       }
       if(password.equals(company.getPassword())){
           return Result.success();
       }
       return Result.error("密码错误");
   }
}
