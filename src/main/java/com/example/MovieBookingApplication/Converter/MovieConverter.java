package com.example.MovieBookingApplication.Converter;

import com.example.MovieBookingApplication.Model.MovieEntity;
import com.example.MovieBookingApplication.Dto.EntryDto.MovieEntryDto;
import com.example.MovieBookingApplication.Dto.ResponseDto.MovieNameAndIdObject;
import com.example.MovieBookingApplication.Dto.ResponseDto.MovieResponseDto;
import lombok.experimental.UtilityClass;

@UtilityClass
public class MovieConverter {


    public static MovieEntity convertDtoToEntity(MovieEntryDto movieEntryDto){

        return MovieEntity.builder() //.attribute (value)
                .name(movieEntryDto.getName())
                .releaseDate(movieEntryDto.getReleaseDate()).build();

    }


    public static MovieResponseDto convertEntityToDto(MovieEntity movieEntity){

        return MovieResponseDto.builder().id(movieEntity.getId()).releaseDate(movieEntity.getReleaseDate()).name(movieEntity.getName()).build();
    }

    public static MovieNameAndIdObject convertEntityToThisObject(MovieEntity movieEntity){


        return MovieNameAndIdObject.builder().
                id(movieEntity.getId())
                .name(movieEntity.getName()).build();

    }
}}
