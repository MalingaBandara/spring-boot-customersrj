package com.bitlord.pos.util.mapper;


import com.bitlord.pos.dto.core.CustomerDto;
import com.bitlord.pos.dto.response.ResponseCustomerDto;
import com.bitlord.pos.entity.Customer;
import org.mapstruct.Mapper;

@Mapper ( componentModel = "spring" )
public interface CustomerMapper {

    Customer toCustomer ( CustomerDto dto );

    ResponseCustomerDto toResponseCustomerDto ( Customer customer );

}
