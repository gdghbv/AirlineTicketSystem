package com.example.airline_ticket_system_idea.mapper;



import com.example.airline_ticket_system_idea.pojo.Customer;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface CustomerViewMapper {


    @Select("SELECT * FROM customer_info where citizenID = #{customerId}")
    Customer getCustomerMessages(String citizenId);



    @Select("update customer_info set name = #{name}, email = #{email}, phoneNumber = #{phone}, points = #{points},password = #{password} where citizenID = #{citizenID}")
    void updateCustomerMessages(Customer customer);
}
