package com.example.MovieBookingApplication.Repository;

import com.example.MovieBookingApplication.Model.TheaterEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TheaterRepository extends JpaRepository<TheaterEntity,Integer> {
}
