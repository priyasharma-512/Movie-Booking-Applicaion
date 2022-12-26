package com.example.MovieBookingApplication.Service;

import com.example.MovieBookingApplication.Dto.BookTicketRequestDto;
import com.example.MovieBookingApplication.Dto.ResponseDto.TicketResponseDto;

public interface TicketService {


    TicketResponseDto getTicket(int id);

    TicketResponseDto bookTicket(BookTicketRequestDto bookTicketRequestDto);

}
