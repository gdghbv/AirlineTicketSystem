package com.example.airline_ticket_system_idea.service.Impl;

import com.example.airline_ticket_system_idea.mapper.CustomerViewMapper;
import com.example.airline_ticket_system_idea.pojo.Customer;
import com.example.airline_ticket_system_idea.service.CustomerViewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CustomerViewServiceImpl implements CustomerViewService {
         @Autowired
         private CustomerViewMapper customerViewMapper;

    @Override
    public Customer getCustomerMessages(String citizenId) {
        return customerViewMapper.getCustomerMessages(citizenId);
    }

    @Override
    public void updateCustomerMessages(Customer customer) {
        customerViewMapper.updateCustomerMessages(customer);
    }


}

