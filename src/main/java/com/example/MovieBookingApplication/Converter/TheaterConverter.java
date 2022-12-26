package com.example.MovieBookingApplication.Converter;

import com.example.MovieBookingApplication.Model.TheaterEntity;
import com.example.MovieBookingApplication.Dto.EntryDto.TheaterEntryDto;
import com.example.MovieBookingApplication.Dto.ResponseDto.TheaterResponseDto;
import lombok.experimental.UtilityClass;

@UtilityClass
public class TheaterConverter {

    public static TheaterEntity convertDtoToEntity(TheaterEntryDto theaterEntryDto){

        return TheaterEntity.builder().address(theaterEntryDto.getAddress())
                .city(theaterEntryDto.getCity()).name(theaterEntryDto.getName()).type(theaterEntryDto.getTheatreType()).build();


    }

    public static TheaterResponseDto convertEntityToDto(TheaterEntity theaterEntity){

        return TheaterResponseDto.builder().id(theaterEntity.getId()).name(theaterEntity.getName())
                .city(theaterEntity.getCity()).address(theaterEntity.getAddress())
                .type(theaterEntity.getType())
                .build();
    }
}
