package com.example.MovieBookingApplication.Dto.EntryDto;

import com.example.MovieBookingApplication.Enums.TheaterType;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class TheaterEntryDto {

    String name;
    String address;
    String city;
    TheaterType theatreType;

}
