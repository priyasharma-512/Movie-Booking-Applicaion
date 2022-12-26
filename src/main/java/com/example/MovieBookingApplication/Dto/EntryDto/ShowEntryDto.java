package com.example.MovieBookingApplication.Dto.EntryDto;

import com.example.MovieBookingApplication.Dto.ResponseDto.MovieResponseDto;
import com.example.MovieBookingApplication.Dto.ResponseDto.TheaterResponseDto;
import com.sun.istack.NotNull;
import lombok.Builder;
import lombok.Data;

import java.time.LocalDate;
import java.time.LocalTime;

@Data
@Builder
public class ShowEntryDto {

    @NotNull
    private LocalDate showDate;

    @NotNull
    private LocalTime showTime;

    @NotNull
    private MovieResponseDto movieResponseDto;

    @NotNull
    private TheaterResponseDto theaterResponseDto;
}