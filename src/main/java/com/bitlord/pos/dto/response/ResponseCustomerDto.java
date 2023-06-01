package com.bitlord.pos.dto.response;


import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class ResponseCustomerDto {

    private long publicId;

    private String name;

    private String address;

    private double salary;

    private boolean activeState;

}