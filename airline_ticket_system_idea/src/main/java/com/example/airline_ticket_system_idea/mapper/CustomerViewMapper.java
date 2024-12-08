package com.example.airline_ticket_system_idea.mapper;



import com.example.airline_ticket_system_idea.pojo.Customer;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface CustomerViewMapper {


    @Select("SELECT * FROM customer_info where citizenID = #{customerId}")
    Customer getCustomerMessages(String citizenId);



    @Select("update customer_info set name = #{name}, phoneNumber = #{phone}, points = #{points} where email = #{email}")
    void updateCustomerMessages(Customer customer);
}
