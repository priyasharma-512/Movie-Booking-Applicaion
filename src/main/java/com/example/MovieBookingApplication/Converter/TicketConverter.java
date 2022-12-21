package com.example.MovieBookingApplication.Converter;

import com.example.MovieBookingApplication.Model.TicketEntity;
import com.example.MovieBookingApplication.Dto.ResponseDto.TicketResponseDto;

public class TicketConverter {

    public static TicketResponseDto convertEntityToDto(TicketEntity ticketEntity){

        return TicketResponseDto.builder().id((int) ticketEntity.getId()).amount(ticketEntity.getAmount())
                .alloted_seats(ticketEntity.getAllottedSeats())
                .build();

    }
}
