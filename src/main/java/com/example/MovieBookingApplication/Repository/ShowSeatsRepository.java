package com.example.MovieBookingApplication.Repository;

import com.example.MovieBookingApplication.Model.ShowSeatsEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ShowSeatsRepository extends JpaRepository<ShowSeatsEntity,Integer> {
}
