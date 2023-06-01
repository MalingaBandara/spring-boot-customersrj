package com.bitlord.pos.api;


import com.bitlord.pos.db.Database;
import com.bitlord.pos.dto.request.RequestCustomerDto;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping( "/api/v1/customers" )
public class CustomerController { // Customer CRUD

     /*
    * {
    "name":"kamal addarararchchi",
    "address":"Moratuwa",
    "salary":25000
} *
    *
    * */

    @PostMapping
    public String createCustomer( @RequestBody RequestCustomerDto customerDto ) {

        return Database.createCustomr(customerDto).toString();
    }


    @PutMapping
    public String updateCustomer(){ return "updateCustomer"; }

    @DeleteMapping
    public String deleteCustomer(){ return "deleteCustomer"; }

    @GetMapping
    public String findCustomer(){ return "findCustomer"; }

    @GetMapping  ("/list" )
    public String getAllCustomers(){ return "getAllCustomers"; }

}
