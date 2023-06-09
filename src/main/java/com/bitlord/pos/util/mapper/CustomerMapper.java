package com.bitlord.pos.util.mapper;


import com.bitlord.pos.dto.core.CustomerDto;
import com.bitlord.pos.dto.response.ResponseCustomerDto;
import com.bitlord.pos.entity.Customer;
import org.mapstruct.Mapper;
import org.springframework.data.domain.Page;

import java.util.List;

@Mapper ( componentModel = "spring" )
public interface CustomerMapper {

    Customer toCustomer ( CustomerDto dto );

    ResponseCustomerDto toResponseCustomerDto ( Customer customer );

    List<ResponseCustomerDto> toResponseCustomerDtoList ( Page<Customer> page );

}
