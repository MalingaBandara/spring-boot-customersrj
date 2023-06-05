package com.bitlord.pos.service;

import com.bitlord.pos.dto.request.RequestCustomerDto;
import com.bitlord.pos.dto.response.ResponseCustomerDto;
import com.bitlord.pos.dto.response.paginated.model.CustomerPaginatedDto;

public interface CustomerService {

    public ResponseCustomerDto createCustomer(RequestCustomerDto dto);

    public ResponseCustomerDto findCustomer(long id) throws ClassNotFoundException;

    public ResponseCustomerDto updateCustomer(RequestCustomerDto dto, long id);

    public void deleteCustomer(long id);

    public CustomerPaginatedDto searchAllCustomers(int page, int size, String searchText);

}
