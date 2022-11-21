package com.binar.seat.controller;

import com.binar.seat.dto.SeatDTO;
import com.binar.seat.model.Seats;
import com.binar.seat.service.SeatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/seats")
public class SeatController {

    @Autowired
    SeatService seatService;

    @PostMapping("/create")
    public SeatDTO create(@RequestBody SeatDTO request) {
        final Seats schedule = seatService.mapToEntity(request);
        final Seats result = seatService.create(schedule);
        return seatService.mapToDto(result);
    }

    @GetMapping("/all")
    public List<SeatDTO> findAll() {
        return seatService.findAll().stream().map(schedule -> seatService.mapToDto(schedule)).toList();
    }

}
