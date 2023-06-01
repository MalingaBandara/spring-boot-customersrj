package com.bitlord.pos.dto.core;

import lombok.*;

import java.sql.Blob;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class CustomerDto {

    private long id;

    private long publicId;

    private String name;

    private String address;

    private double salary;

    private boolean activeState;


    /*===============*/
    private Blob fileName;
    private Blob resourceUrl;
    private Blob directory;
    private Blob hash;
    /*===============*/

}