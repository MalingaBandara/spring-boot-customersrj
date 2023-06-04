package com.bitlord.pos.api;


import com.bitlord.pos.db.Database;
import com.bitlord.pos.dto.request.RequestCustomerDto;
import com.bitlord.pos.util.StandardResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
    public ResponseEntity<StandardResponse> createCustomer(@RequestBody RequestCustomerDto customerDto ) {

        var saveData= Database.createCustomr( customerDto );

        return new ResponseEntity<>(  new StandardResponse( 201, "cutomer saved!", saveData ),  HttpStatus.CREATED ) ;
    }

    @GetMapping( "/{id}" )
    public ResponseEntity<StandardResponse> findCustomer (@PathVariable int id) throws ClassNotFoundException {

        return new ResponseEntity<>( new StandardResponse( 200, "customer Data!", Database.findCustomer(id)), HttpStatus.OK );
    }


    @PutMapping(params = "id")
    public ResponseEntity<StandardResponse> updateCustomer( @RequestParam int id,  @RequestBody RequestCustomerDto customerDto ) throws ClassNotFoundException {

        var savedData = Database.updateCustomer(customerDto,id);

        return new ResponseEntity<>(
                new StandardResponse(201,"customer Updated!",savedData),
                HttpStatus.CREATED
        );

    }

    @DeleteMapping
    public String deleteCustomer(){ return "deleteCustomer"; }

    @GetMapping  ("/list" )
    public String getAllCustomers(){ return "getAllCustomers"; }

}
