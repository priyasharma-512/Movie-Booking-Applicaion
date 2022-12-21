package com.example.MovieBookingApplication.Repository;

import com.example.MovieBookingApplication.Model.MovieEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MovieRepository extends JpaRepository<MovieEntity,Integer> {

    boolean existsByName(String name);
}
