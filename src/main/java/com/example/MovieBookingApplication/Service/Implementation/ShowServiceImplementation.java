package com.example.MovieBookingApplication.Service.Implementation;

import com.example.MovieBookingApplication.Converter.ShowConverter;
import com.example.MovieBookingApplication.Dto.EntryDto.ShowEntryDto;
import com.example.MovieBookingApplication.Dto.ResponseDto.ShowResponseDto;
import com.example.MovieBookingApplication.Model.*;
import com.example.MovieBookingApplication.Repository.MovieRepository;
import com.example.MovieBookingApplication.Repository.ShowRepository;
import com.example.MovieBookingApplication.Repository.ShowSeatsRepository;
import com.example.MovieBookingApplication.Repository.TheaterRepository;
import com.example.MovieBookingApplication.Service.ShowService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Slf4j //Helps
@Service
public class ShowServiceImplementation implements ShowService {

    @Autowired
    MovieRepository movieRepository;

    @Autowired
    TheaterRepository theaterRepository;

    @Autowired
    ShowSeatsRepository showSeatsRepository;

    @Autowired
    ShowRepository showRepository;

    @Override
    public ShowResponseDto addShow(ShowEntryDto showEntryDto) {

        ShowEntity showEntity = ShowConverter.convertDtoToEntity(showEntryDto);

        //MovieEntity
        MovieEntity movieEntity = movieRepository.findById(showEntryDto.getMovieResponseDto().getId()).get();

        TheaterEntity theaterEntity = theaterRepository.findById(showEntryDto.getTheaterResponseDto().getId()).get();


        showEntity.setMovie(movieEntity); //Why are we setting these varibble
        showEntity.setTheater(theaterEntity);

        showEntity = showRepository.save(showEntity);


        //We need to pass the list of the theater seats
        List<ShowSeatsEntity> showSeatsEntityList = generateShowEntitySeats(theaterEntity.getSeats(),showEntity);
        showSeatsRepository.saveAll(showSeatsEntityList);
        //We need to create Response Show Dto.

        ShowResponseDto showResponseDto = ShowConverter.convertEntityToDto(showEntity,showEntryDto);

        return showResponseDto;
    }

    public List<ShowSeatsEntity> generateShowEntitySeats(List<TheaterSeatsEntity> theaterSeatsEntityList,ShowEntity showEntity){

        List<ShowSeatsEntity> showSeatsEntityList = new ArrayList<>();

        //log.info(String.valueOf(theaterSeatsEntityList));
//        log.info("The list of theaterEntity Seats");
//        for(TheaterSeatsEntity tse: theaterSeatsEntityList){
//            log.info(tse.toString());
//        }


        for(TheaterSeatsEntity tse : theaterSeatsEntityList){

            ShowSeatsEntity showSeatsEntity = ShowSeatsEntity.builder().seatNumber(tse.getSeatNumber())
                    .seatType(tse.getSeatType())
                    .rate(tse.getRate())
                    .build();

            showSeatsEntityList.add(showSeatsEntity);
        }


        //We need to set the show Entity for each of the ShowSeat....
        for(ShowSeatsEntity showSeatsEntity:showSeatsEntityList){
            showSeatsEntity.setShow(showEntity);
        }

        showEntity.setSeats(showSeatsEntityList);
        return showSeatsEntityList;

    }

}
