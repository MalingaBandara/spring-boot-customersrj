package com.bitlord.pos.api;

import com.bitlord.pos.dto.request.RequestUserDto;
import com.bitlord.pos.util.StandardResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
@RequestMapping( "/api/v1/user" )
public class UserController {


    @PostMapping( params = "role" )
    public ResponseEntity<StandardResponse> createUser ( @RequestBody RequestUserDto dto, @RequestParam String role ) {



    }

}
