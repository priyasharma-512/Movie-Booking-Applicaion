package com.example.MovieBookingApplication.Repository;

import com.example.MovieBookingApplication.Model.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<UserEntity,Integer> {
}
