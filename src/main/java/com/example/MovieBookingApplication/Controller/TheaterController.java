package com.example.MovieBookingApplication.Controller;

import com.example.MovieBookingApplication.Service.Implementation.TheaterServiceImplementation;
import com.example.MovieBookingApplication.Dto.EntryDto.TheaterEntryDto;
import com.example.MovieBookingApplication.Dto.ResponseDto.TheaterResponseDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("theater")
public class TheaterController {

    @Autowired
    TheaterServiceImplementation theaterService;


    @PostMapping("add")
    public TheaterResponseDto addTheater(@RequestBody() TheaterEntryDto theaterEntryDto){

        return theaterService.addTheater(theaterEntryDto);

    }

}
