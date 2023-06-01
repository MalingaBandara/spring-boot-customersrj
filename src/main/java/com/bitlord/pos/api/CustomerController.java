package com.bitlord.pos.api;


import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping( "/api/v1/customers" )
public class CustomerController { // Customer CRUD

    public String createCustomer(){ return "createCustomer"; }

    public String updateCustomer(){ return "updateCustomer"; }

    public String deleteCustomer(){ return "deleteCustomer"; }

    public String findCustomer(){ return "findCustomer"; }

    public String getAllCustomers(){ return "getAllCustomers"; }

}
