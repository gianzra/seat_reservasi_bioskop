package com.binar.seat.repository;

import com.binar.seat.model.Seats;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SeatRepository extends JpaRepository<Seats, Integer> {


}
