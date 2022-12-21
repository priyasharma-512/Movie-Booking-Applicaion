package com.example.MovieBookingApplication.Service.Implementation;

import com.example.MovieBookingApplication.Model.ShowEntity;
import com.example.MovieBookingApplication.Model.ShowSeatsEntity;
import com.example.MovieBookingApplication.Model.TicketEntity;
import com.example.MovieBookingApplication.Model.UserEntity;
import com.example.MovieBookingApplication.Repository.ShowRepository;
import com.example.MovieBookingApplication.Repository.TicketRepository;
import com.example.MovieBookingApplication.Repository.UserRepository;
import com.example.MovieBookingApplication.Service.TicketService;
import com.example.MovieBookingApplication.Converter.ShowConverter;
import com.example.MovieBookingApplication.Converter.TicketConverter;
import com.example.MovieBookingApplication.Converter.UserConverter;
import com.example.MovieBookingApplication.Dto.BookTicketRequestDto;
import com.example.MovieBookingApplication.Dto.ResponseDto.TicketResponseDto;
import com.example.MovieBookingApplication.Dto.TicketDto;
import com.example.MovieBookingApplication.Enums.SeatType;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Service
@Slf4j
public class TicketServiceImplementation implements TicketService {

    @Autowired
    UserRepository userRepository;

    @Autowired
    ShowRepository showRepository;

    @Autowired
    TicketRepository ticketRepository;

    @Override
    public TicketResponseDto getTicket(int id) {

        TicketEntity ticketEntity = ticketRepository.findById(id).get();

        UserConverter TicketConvertor;
        TicketResponseDto ticketResponseDto = TicketConverter.convertEntityToDto(ticketEntity);

        return ticketResponseDto;

    }

    @Override
    public TicketResponseDto bookTicket(BookTicketRequestDto bookTicketRequestDto) {


        UserEntity userEntity = userRepository.findById(bookTicketRequestDto.getId()).get();
        ShowEntity showEntity = showRepository.findById(bookTicketRequestDto.getShowId()).get();

        log.info("Ticket half processed");

        Set<String> requestSeats = bookTicketRequestDto.getRequestedSeats();


        List<ShowSeatsEntity> showSeatsEntityList = showEntity.getSeats();

        // for(ShowSeatsEntity seat: showSeatsEntityList) System.out.print(seat+" ");


//        //Another way to iterate. Try to study about it.
//        List<ShowSeatsEntity> bookedSeats = showSeatsEntityList
//                .stream()
//                .filter(seat -> seat.getSeatType().equals(bookTicketRequestDto.getSeatType())&&!seat.isBooked()&&
//                        requestSeats.contains(seat.getSeatNumber()))
//                .collect(Collectors.toList());



        List<ShowSeatsEntity> bookedSeats = new ArrayList<>();

        for(ShowSeatsEntity seat :showSeatsEntityList){

            if(!seat.isBooked()&&seat.getSeatType().equals(bookTicketRequestDto.getSeatType())&&requestSeats.contains(seat.getSeatNumber())){
                bookedSeats.add(seat);
            }
        }

        for(ShowSeatsEntity seat: bookedSeats) System.out.println(seat);
        if(bookedSeats.size()!=requestSeats.size()){
            //Al the seats were not avaiable
            throw new Error("All Seats not available");
        }

        //Step 2

        TicketEntity ticketEntity = TicketEntity.builder().
                user(userEntity)
                .show(showEntity)
                .seats(bookedSeats).
                build();



        //Step 3 :

        double amount = 0;

        for(ShowSeatsEntity showSeatsEntity: bookedSeats){

            showSeatsEntity.setBooked(true);
            showSeatsEntity.setBookedAt(new Date());
            showSeatsEntity.setTicket(ticketEntity);

            amount = amount + showSeatsEntity.getRate();
        }

        ticketEntity.setBookedAt(new Date());
        ticketEntity.setAllottedSeats(convertListOfSeatsEntityToString(bookedSeats));
        ticketEntity.setAmount(amount);


        //Connect in thw Show and the user

        showEntity.getTickets().add(ticketEntity);


        //Add the ticket in the tickets list of the user Entity
        userEntity.getTicketEntities().add(ticketEntity);


        ticketEntity = ticketRepository.save(ticketEntity);

        ShowConverter TicketConvertor;
        return TicketConverter.convertEntityToDto(ticketEntity);


    }

    public String convertListOfSeatsEntityToString(List<ShowSeatsEntity> bookedSeats){

        String str = "";
        for(ShowSeatsEntity showSeatsEntity : bookedSeats){

            str = str + showSeatsEntity.getSeatNumber()+" ";
        }

        return str;

    }
}
