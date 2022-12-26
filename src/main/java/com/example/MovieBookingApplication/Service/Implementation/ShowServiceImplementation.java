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

        //set MovieEntity -> get movieEntity corresponding to id fetching movie corresponding to id
        MovieEntity movieEntity = movieRepository.findById(showEntryDto.getMovieResponseDto().getId()).get();
        showEntity.setMovie(movieEntity);

        //set theatreEntity
        TheaterEntity theaterEntity = theaterRepository.findById(showEntryDto.getTheaterResponseDto().getId()).get();
        showEntity.setTheater(theaterEntity);

        showEntity = showRepository.save(showEntity);


        //We need to pass the list of the theater seats
        List<ShowSeatsEntity> showSeatsEntityList = generateShowEntitySeats(theaterEntity.getSeats(),showEntity);
        showSeatsRepository.saveAll(showSeatsEntityList);

        //We need to create Response Show Dto.
        ShowResponseDto showResponseDto = ShowConverter.convertEntityToDto(showEntity,showEntryDto);

        return showResponseDto;
    }

   /* @Override
    public static ShowResponseDto getShow(int id) {
        ShowEntity showEntity = ShowRepository.findById(id).get();

        ShowConverter showConverter;
        ShowResponseDto showResponseDto = ShowConverter.convertEntityToDto(showEntity, ShowEntryDto);

        return showResponseDto;
    }*/

    //creating copy of seats
    public List<ShowSeatsEntity> generateShowEntitySeats(List<TheaterSeatsEntity> theaterSeatsEntityList,ShowEntity showEntity){

        List<ShowSeatsEntity> showSeatsEntityList = new ArrayList<>();

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
