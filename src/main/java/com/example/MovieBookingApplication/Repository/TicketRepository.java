package com.example.MovieBookingApplication.Repository;

import com.example.MovieBookingApplication.Model.TicketEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TicketRepository extends JpaRepository<TicketEntity, Integer> {
}
