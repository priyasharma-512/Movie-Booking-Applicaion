package com.example.MovieBookingApplication.Service;

import com.example.MovieBookingApplication.Dto.EntryDto.TheaterEntryDto;
import com.example.MovieBookingApplication.Dto.ResponseDto.TheaterResponseDto;

public interface TheaterService {


    TheaterResponseDto addTheater(TheaterEntryDto theaterEntryDto);

    TheaterResponseDto getTheater(int id);

}
