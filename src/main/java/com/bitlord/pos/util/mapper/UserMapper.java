package com.bitlord.pos.util.mapper;


import com.bitlord.pos.dto.core.UserDto;
import com.bitlord.pos.entity.User;
import org.mapstruct.Mapper;


import java.util.List;

@Mapper ( componentModel = "spring" )
public interface UserMapper {

    User toUser (UserDto dto );


}
