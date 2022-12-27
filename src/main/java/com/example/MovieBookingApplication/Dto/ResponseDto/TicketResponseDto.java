package com.example.MovieBookingApplication.Dto.ResponseDto;

import lombok.Builder;
import lombok.Data;

import java.util.Set;


@Data
@Builder
public class TicketResponseDto {


    int id;
    String alloted_seats;
    double amount;

}