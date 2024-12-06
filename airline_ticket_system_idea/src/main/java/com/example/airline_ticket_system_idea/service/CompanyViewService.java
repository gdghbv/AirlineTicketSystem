package com.example.airline_ticket_system_idea.service;

import com.example.airline_ticket_system_idea.pojo.CompanyAircraft;
import com.example.airline_ticket_system_idea.pojo.CompanyRoutes;

import java.util.List;

public interface CompanyViewService {
    List<CompanyAircraft> list();

    void addAircraft(CompanyAircraft companyAircraft);

    CompanyAircraft findAircraftByID(String aircraftId);

    void updateAircraft(CompanyAircraft companyAircraft);

    void deleteAircraft(String aircraftId);

    List<CompanyRoutes> routesList();

    CompanyRoutes findRoutesByID(String routeID);

    void addRoutes(CompanyRoutes companyRoutes);

    void updateRoutes(CompanyRoutes companyRoutes);

    void deleteRoutes(String routeID);
}
