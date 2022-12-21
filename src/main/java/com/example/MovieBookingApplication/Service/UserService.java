package com.example.MovieBookingApplication.Service;

import com.example.MovieBookingApplication.Dto.EntryDto.UserEntryDto;
import com.example.MovieBookingApplication.Dto.ResponseDto.UserResponseDto;

public interface UserService { //Designing part

    void addUser(UserEntryDto userEntryDto);

    UserResponseDto getUser(int id);


}
