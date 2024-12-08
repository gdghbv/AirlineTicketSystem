package com.example.airline_ticket_system_idea.controller;


import com.example.airline_ticket_system_idea.pojo.Customer;
import com.example.airline_ticket_system_idea.pojo.Result;
import com.example.airline_ticket_system_idea.service.CustomerService;
import com.example.airline_ticket_system_idea.service.Impl.CustomerViewServiceImpl;
import com.example.airline_ticket_system_idea.util.JwtUtil;
import com.example.airline_ticket_system_idea.util.ThreadLocalUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@Slf4j
@RestController
@RequestMapping("/CustomerView")
public class CustomerViewController {


    @Autowired
    private CustomerViewServiceImpl CustomerViewServiceImpl;

    @GetMapping("/CustomerMessages")
    public Result<Customer> getCustomerView(){
             Map<String, Object> claims = ThreadLocalUtil.get();
             String citizenId = (String) claims.get("citizenID");
       Customer customer= CustomerViewServiceImpl.getCustomerMessages(citizenId);
               log.info("CustomerMessages: "+customer);
        return Result.success(customer);
    }


            @PostMapping("/updateCustomerMessages")
        public Result updateCustomerMessages(Customer customer) {
                      Map<String, Object> claims = ThreadLocalUtil.get();
                      String citizenId = (String) claims.get("citizenID");
                      customer.setCitizenID(citizenId);
                      CustomerViewServiceImpl.updateCustomerMessages(customer);
                      return Result.success("修改成功");
            }
}
