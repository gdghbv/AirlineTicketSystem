package com.example.airline_ticket_system_idea.mapper;

import com.example.airline_ticket_system_idea.pojo.CompanyAircraft;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface CompanyViewMapper {
//    查询该公司旗下所有飞机信息
 @Select("SELECT * FROM company_aircraft_info where companyID = #{companyID}" )
    List<CompanyAircraft> list(@Param("companyID") String companyID);

 @Insert("INSERT INTO company_aircraft_info(companyID, aircraftID, aircraftType, seatCount) VALUES(#{companyID}, #{aircraftID}, #{aircraftType}, #{seatCount})")
    void addAircraft(CompanyAircraft companyAircraft);

 @Select("SELECT * FROM company_aircraft_info WHERE aircraftID = #{aircraftID}")
    CompanyAircraft findAircraftByID(String aircraftID);

@Update("UPDATE company_aircraft_info SET aircraftType = #{aircraftType}, seatCount = #{seatCount} WHERE aircraftID = #{aircraftID}")
    void updateAircraft(CompanyAircraft companyAircraft);

    @Delete("DELETE FROM company_aircraft_info WHERE aircraftID = #{aircraftID}")
    void deleteAircraft(@Param("aircraftID") String aircraftID);
}

