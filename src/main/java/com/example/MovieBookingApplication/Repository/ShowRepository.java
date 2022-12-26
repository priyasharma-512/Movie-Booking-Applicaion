package com.example.MovieBookingApplication.Repository;

import com.example.MovieBookingApplication.Model.ShowEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ShowRepository extends JpaRepository<ShowEntity, Integer> {
}
