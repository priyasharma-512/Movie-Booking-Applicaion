package com.example.MovieBookingApplication.Repository;

import com.example.MovieBookingApplication.Model.TheaterSeatsEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TheaterSeatsRepository extends JpaRepository<TheaterSeatsEntity, Integer> {
}
