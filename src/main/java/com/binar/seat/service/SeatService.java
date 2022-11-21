package com.binar.seat.service;

import com.binar.seat.dto.SeatDTO;
import com.binar.seat.model.Seats;

import java.util.List;

public interface SeatService {

    List<Seats> findAll();
    Seats create(Seats seat);

    SeatDTO mapToDto(Seats seats);
    Seats mapToEntity(SeatDTO seatDTO);

}
