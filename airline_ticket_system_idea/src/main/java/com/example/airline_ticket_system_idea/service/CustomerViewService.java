package com.example.airline_ticket_system_idea.service;

import com.example.airline_ticket_system_idea.pojo.Customer;

public interface CustomerViewService {
    Customer getCustomerMessages(String citizenId);


    void updateCustomerMessages(Customer customer);
}
