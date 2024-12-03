package com.example.airline_ticket_system_idea.service;

import com.example.airline_ticket_system_idea.pojo.CompanyAircraft;

import java.util.List;

public interface CompanyViewService {
    List<CompanyAircraft> list();

    void addAircraft(CompanyAircraft companyAircraft);

    CompanyAircraft findAircraftByID(String aircraftId);

    void updateAircraft(CompanyAircraft companyAircraft);

    void deleteAircraft(String aircraftId);
}
