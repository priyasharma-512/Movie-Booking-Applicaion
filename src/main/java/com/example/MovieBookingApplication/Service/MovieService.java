package com.example.MovieBookingApplication.Service;

import com.example.MovieBookingApplication.Dto.EntryDto.MovieEntryDto;
import com.example.MovieBookingApplication.Dto.ResponseDto.MovieNameAndIdObject;
import com.example.MovieBookingApplication.Dto.ResponseDto.MovieResponseDto;

public interface MovieService {

    //Add movie
    MovieResponseDto addMovie(MovieEntryDto movieEntryDto);


    //get movie
    MovieResponseDto getMovie(int id);

    MovieNameAndIdObject getNameAndId(int id);


}
