package com.bitlord.pos.service;


import com.bitlord.pos.dto.request.RequestUserDto;

public interface UserService {

    public void  createUser  ( RequestUserDto dto , String role );

}
