package com.example.airline_ticket_system_idea.service.Impl;

import com.example.airline_ticket_system_idea.mapper.CompanyViewMapper;
import com.example.airline_ticket_system_idea.pojo.CompanyAircraft;
import com.example.airline_ticket_system_idea.service.CompanyViewService;
import com.example.airline_ticket_system_idea.util.ThreadLocalUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class CompanyViewServiceImpl implements CompanyViewService {
    @Autowired
    private CompanyViewMapper companyViewMapper;


    @Override
    public List<CompanyAircraft> list() {
        Map<String, Object> map = ThreadLocalUtil.get();
        String companyID= (String) map.get("companyID");
        return companyViewMapper.list(companyID);
    }

}