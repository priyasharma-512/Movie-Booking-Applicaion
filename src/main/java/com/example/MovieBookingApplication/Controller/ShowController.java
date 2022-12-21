package com.example.MovieBookingApplication.Controller;

import com.example.MovieBookingApplication.Service.Implementation.ShowServiceImplementation;
import com.example.MovieBookingApplication.Dto.EntryDto.ShowEntryDto;
import com.example.MovieBookingApplication.Dto.ResponseDto.ShowResponseDto;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
@RequestMapping("show")
public class ShowController {


    @Autowired
    ShowServiceImplementation showService;


    @PostMapping("/add")
    public ShowResponseDto addShow(@RequestBody() ShowEntryDto showEntryDto){

        log.info("Here we are");

        return showService.addShow(showEntryDto);
    }


}
