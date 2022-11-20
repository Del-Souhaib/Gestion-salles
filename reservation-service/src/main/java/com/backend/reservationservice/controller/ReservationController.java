package com.backend.reservationservice.controller;

import com.backend.reservationservice.model.Reservation;
import com.backend.reservationservice.repository.ReservationRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/api/reservations")
public class ReservationController {

    @Autowired
    private ReservationRepository reservationRepository;

    @GetMapping("")
    public List<Reservation> ReservationList(){
        return reservationRepository.findAll();
    }

    @GetMapping("/{id}")
    public Reservation Reservation(@PathVariable("id") String id){
        return reservationRepository.findFirstById(id);
    }

    @PostMapping("")
    public void addReservation(@RequestBody Reservation reservation)  {
        reservationRepository.save(reservation);
    }

    @PutMapping("")
    public void updateReservation(@RequestBody Reservation reservation)  {
        reservationRepository.save(reservation);
    }


    @DeleteMapping("/{id}")
    public void deleteReservation(@PathVariable("id") String id)  {
        reservationRepository.deleteById(id);
    }

}
