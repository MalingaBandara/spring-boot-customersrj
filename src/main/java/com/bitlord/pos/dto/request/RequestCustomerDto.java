package com.bitlord.pos.dto.request;


import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class RequestCustomerDto {

    private String name;

    private String address;

    private double salary;

}
