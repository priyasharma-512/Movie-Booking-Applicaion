package com.example.MovieBookingApplication.Service.Implementation;

import com.example.MovieBookingApplication.Model.UserEntity;
import com.example.MovieBookingApplication.Repository.UserRepository;
import com.example.MovieBookingApplication.Service.UserService;
import com.example.MovieBookingApplication.Converter.UserConverter;
import com.example.MovieBookingApplication.Dto.EntryDto.UserEntryDto;
import com.example.MovieBookingApplication.Dto.ResponseDto.UserResponseDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImplementation implements UserService {

    @Autowired
    UserRepository userRepository;

    @Override
    public void addUser(UserEntryDto userEntryDto) {

        UserEntity userEntity = UserConverter.convertDtoToEntity(userEntryDto); //Cleaner
        userRepository.save(userEntity);
    }

    @Override
    public UserResponseDto getUser(int id) {

        UserEntity user = new UserEntity(); //By default user.

        UserEntity userEntity = userRepository.findById(id).get();

        UserResponseDto userResponseDto = UserConverter.convertEntityToDto(userEntity);

        return userResponseDto;
    }
}
