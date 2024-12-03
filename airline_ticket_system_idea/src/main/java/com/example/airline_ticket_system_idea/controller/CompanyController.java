package com.example.airline_ticket_system_idea.controller;

import com.example.airline_ticket_system_idea.pojo.Company;
import com.example.airline_ticket_system_idea.pojo.Result;
import com.example.airline_ticket_system_idea.service.CompanyService;
import com.example.airline_ticket_system_idea.util.JwtUtil;
import com.example.airline_ticket_system_idea.util.ThreadLocalUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

import static com.example.airline_ticket_system_idea.util.Md5Util.checkPassword;


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
       if(checkPassword(password,company.getPassword())){
           //登录成功，生成令牌
           Map<String, Object> claims = new HashMap<>();
           claims.put("companyID", company.getCompanyID()); //放入注册用户的id
           claims.put("email",company.getEmail());//放入注册用户的username
           String token = JwtUtil.genToken(claims); //生成token
           return Result.success(token); //响应JWT token令牌字符串

       }
       return Result.error("密码错误");
   }
    @GetMapping("/companyInfo")
    public Result<Company> companyInfo(){
//        Map<String, Object> map = JwtUtil.parseToken(token);
//        String email = (String) map.get("email");
        Map<String, Object> map = ThreadLocalUtil.get();
        String email = (String) map.get("email");
        Company company = companyService.findCompanyByEmail(email);
        return Result.success(company);
    }
    @PutMapping("/updateCompanyInfo")
    public Result update(@RequestBody Company company){

       companyService.update(company);
       return Result.success();
    }
}
