package com.example.MovieBookingApplication.Controller;

import com.example.MovieBookingApplication.Service.Implementation.UserServiceImplementation;
import com.example.MovieBookingApplication.Dto.EntryDto.UserEntryDto;
import com.example.MovieBookingApplication.Dto.ResponseDto.UserResponseDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("user")
public class UserController {


    @Autowired
    UserServiceImplementation userService;

    @PostMapping("/add")
    public ResponseEntity<String> addUser(@RequestBody UserEntryDto userEntryDto){

        userService.addUser(userEntryDto);

        return new ResponseEntity("Added a User successfully", HttpStatus.CREATED);

    }

    @GetMapping("/get/{id}")
    public ResponseEntity<UserResponseDto> getUser(@PathVariable(value = "id")int id){

        UserResponseDto userResponseDto = userService.getUser(id);
        return new ResponseEntity<>(userResponseDto,HttpStatus.OK);
    }

}