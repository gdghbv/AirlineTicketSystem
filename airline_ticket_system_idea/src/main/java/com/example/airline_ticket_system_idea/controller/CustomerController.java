package com.example.airline_ticket_system_idea.controller;


import com.example.airline_ticket_system_idea.pojo.Customer;
import com.example.airline_ticket_system_idea.pojo.Result;
import com.example.airline_ticket_system_idea.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("customer")
public class CustomerController {
    //连接CustomerService
    @Autowired
    private CustomerService customerService;

    //注册的接口
    @PostMapping("register")
    public Result register(String citizenID, String password, String email) {
        //调用CustomerService的findCustomerByEmail方法来检测该用户是否已经注册
        Customer customer = customerService.findCustomerByEmail(email);
        if (customer == null) {
            customerService.register(citizenID, email, password);
            return Result.success();
        } else {
            return Result.error("该邮箱已被注册");
        }
    }

    @PostMapping("login")
    public Result login(String email, String password) {
        Customer customer = customerService.findCustomerByEmail(email);
        if (customer == null) {
            return Result.error("该邮箱未注册");
        }
        if (password.equals(customer.getPassword())) {
            return Result.success();
        } else {
            return Result.error("密码错误");
        }
    }
}
