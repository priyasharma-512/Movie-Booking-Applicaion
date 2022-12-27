package com.example.MovieBookingApplication.Converter;

import com.example.MovieBookingApplication.Model.ShowEntity;
import com.example.MovieBookingApplication.Dto.EntryDto.ShowEntryDto;
import com.example.MovieBookingApplication.Dto.ResponseDto.ShowResponseDto;
import lombok.experimental.UtilityClass;

@UtilityClass
public class ShowConverter {


    public static ShowEntity convertDtoToEntity(ShowEntryDto showDto){

        return ShowEntity.builder().showDate(showDto.getShowDate()).showTime(showDto.getShowTime())
                .build();
    }

    public static ShowResponseDto convertEntityToDto(ShowEntity showEntity){

        return ShowResponseDto.builder()
                .id(showEntity.getId())
                .showTime(showEntity.getShowTime())
                .showDate(showEntity.getShowDate())
                .movieResponseDto(MovieConverter.convertEntityToDto(showEntity.getMovie()))
                .theaterDto(TheaterConverter.convertEntityToDto(showEntity.getTheater()))
                .build();
    }
}
