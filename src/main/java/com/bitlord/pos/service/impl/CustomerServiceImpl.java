package com.bitlord.pos.service.impl;


import com.bitlord.pos.dto.core.CustomerDto;
import com.bitlord.pos.dto.request.RequestCustomerDto;
import com.bitlord.pos.dto.response.ResponseCustomerDto;
import com.bitlord.pos.dto.response.paginated.model.CustomerPaginatedDto;
import com.bitlord.pos.entity.Customer;
import com.bitlord.pos.repo.CustomerRepo;
import com.bitlord.pos.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;
import java.util.Random;

@Service
@Transactional
public class CustomerServiceImpl implements CustomerService {

    private final CustomerRepo customerRepo;

    @Autowired
    public CustomerServiceImpl(CustomerRepo customerRepo) {
        this.customerRepo = customerRepo;
    }


    @Override
    public ResponseCustomerDto createCustomer(RequestCustomerDto dto) {

        CustomerDto customerDto = new CustomerDto(
                0,
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

        Customer customer = new Customer(
                0,
                customerDto.getPublicId(),
                customerDto.getName(),
                customerDto.getAddress(),
                customerDto.getSalary(),
                customerDto.isActiveState(),
                null
        );

        customerRepo.save(customer);

        return new ResponseCustomerDto(
                customerDto.getPublicId(),
                customerDto.getName(),
                customerDto.getAddress(),
                customerDto.getSalary(),
                customerDto.isActiveState()
        );
    }

    @Override
    public ResponseCustomerDto findCustomer(long id) throws ClassNotFoundException {

        Optional< Customer > selectedCustomer = customerRepo.findByPublicId( id );

        if ( selectedCustomer.isPresent() ) {
            return new ResponseCustomerDto(
                    selectedCustomer.get().getPublicId(),
                    selectedCustomer.get().getName(),
                    selectedCustomer.get().getAddress(),
                    selectedCustomer.get().getSalary(),
                    selectedCustomer.get().isActiveState()
            );
        }

        // customerRepo.findById( id );
        throw  new ClassNotFoundException();
    }

    @Override
    public ResponseCustomerDto updateCustomer(RequestCustomerDto dto, long id) {
        return null;
    }

    @Override
    public void deleteCustomer(long id) {

    }

    @Override
    public CustomerPaginatedDto searchAllCustomers(int page, int size, String searchText) {
        return null;
    }
}