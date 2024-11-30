package com.example.airline_ticket_system_idea.mapper;

import com.example.airline_ticket_system_idea.pojo.CompanyAircraft;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface CompanyViewMapper {
//    查询该公司旗下所有飞机信息
 @Select("SELECT * FROM company_aircraft_info where companyID = #{companyID}" )
    List<CompanyAircraft> list(@Param("companyID") String companyID);
}
