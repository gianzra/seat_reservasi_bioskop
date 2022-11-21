package com.binar.seat.service;

import com.binar.seat.dto.SeatDTO;
import com.binar.seat.model.Seats;
import com.binar.seat.repository.SeatRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;


@Service
@Transactional
public class SeatServiceImpl implements SeatService {

    private static final Logger logger = LoggerFactory.getLogger(SeatServiceImpl.class);
    @Autowired
    SeatRepository seatRepository;

    @Override
    public Seats create(Seats seat) {
        logger.info("Menampilkan kursi dari database");
        final Seats result = seatRepository.save(seat);
        return result;
    }

    @Override
    public List<Seats> findAll() {
        logger.info("Mengambil data kursi dari database");
        return seatRepository.findAll();
    }

    ObjectMapper mapper = new ObjectMapper();

    @Override
    public SeatDTO mapToDto(Seats schedules) {
        return mapper.convertValue(schedules, SeatDTO.class);
    }

    @Override
    public Seats mapToEntity(SeatDTO seatDTO) {
        return mapper.convertValue(seatDTO, Seats.class);
    }

}
