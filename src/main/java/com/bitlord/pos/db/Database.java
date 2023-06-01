package com.bitlord.pos.db;

import com.bitlord.pos.dto.core.CustomerDto;
import com.bitlord.pos.dto.request.RequestCustomerDto;
import com.bitlord.pos.dto.response.ResponseCustomerDto;

import java.util.ArrayList;
import java.util.Random;

public class Database {

    public static ArrayList<CustomerDto> customerTable =  new ArrayList<>();

    public static ResponseCustomerDto createCustomr(RequestCustomerDto dto ) {

        CustomerDto customerDto = new CustomerDto(
                new Random().nextInt(100001),
                new Random().nextInt(100001),
                dto.getName(),
                dto.getAddress(),
                dto.getSalary(),
                true,
                null,
                null,
                null,
                null
        );

        customerTable.add(customerDto);

        return new ResponseCustomerDto(
                customerDto.getPublicId(),
                dto.getName(),
                dto.getAddress(),
                dto.getSalary(),
                customerDto.isActiveState()
        );
    }


}

