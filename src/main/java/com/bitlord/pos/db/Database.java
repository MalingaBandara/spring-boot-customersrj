package com.bitlord.pos.db;

import com.bitlord.pos.dto.core.CustomerDto;
import com.bitlord.pos.dto.request.RequestCustomerDto;
import com.bitlord.pos.dto.response.ResponseCustomerDto;

import java.util.ArrayList;
import java.util.Optional;
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


    public static ResponseCustomerDto findCustomer ( int id ) throws ClassNotFoundException {

        Optional<CustomerDto> selectedCustomer = customerTable.stream().filter( e -> e.getPublicId() == id ).findFirst();


        if (selectedCustomer.isPresent()){
            return new ResponseCustomerDto(
                    selectedCustomer.get().getPublicId(),
                    selectedCustomer.get().getName(),
                    selectedCustomer.get().getAddress(),
                    selectedCustomer.get().getSalary(),
                    selectedCustomer.get().isActiveState()
            );
        }
        throw new ClassNotFoundException();
    }


    public static ResponseCustomerDto updateCustomer( RequestCustomerDto dto, int id ) throws ClassNotFoundException {

        Optional<CustomerDto> selectedCustomer =  customerTable.stream().filter( e-> e.getPublicId() == id ).findFirst();

        if (selectedCustomer.isPresent()){
            selectedCustomer.get().setName(dto.getName());
            selectedCustomer.get().setAddress(dto.getAddress());
            selectedCustomer.get().setSalary(dto.getSalary());

                    return new ResponseCustomerDto(
                            selectedCustomer.get().getPublicId(),
                            selectedCustomer.get().getName(),
                            selectedCustomer.get().getAddress(),
                            selectedCustomer.get().getSalary(),
                            selectedCustomer.get().isActiveState()
                    );

        }
        throw new ClassNotFoundException();
    }

    public static void deleteCustomer(int id) throws ClassNotFoundException {

        Optional<CustomerDto> selectedCustomer = customerTable.stream().filter( e-> e.getPublicId() == id ).findFirst();

        if (selectedCustomer.isPresent()){

            customerTable.remove(selectedCustomer.get());
            return;

        }
        throw new ClassNotFoundException();
    }
}

