package com.backend.reservationservice.controller;

import com.backend.reservationservice.model.Reservation;
import com.backend.reservationservice.repository.ReservationRepository;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/api/reservations")
@Slf4j
public class ReservationController {

    @Autowired
    private ReservationRepository reservationRepository;

    @GetMapping("")
    public List<Reservation> ReservationList(){
        return reservationRepository.findAll();
    }

    @GetMapping("/byPitch/{id}")
    public List<Reservation> ReservationListByPïtch(@PathVariable("id") Long id){
        return reservationRepository.findAllByPitch(id);
    }
    @GetMapping("/byDate/{date}")
    public boolean ReservationListByDate(@PathVariable("date") @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss") Date date){
        log.info(String.valueOf(date));
        return reservationRepository.existsAllByDateReservation(date);
    }
    @GetMapping("/byClient/{id}")
    public List<Reservation> ReservationListByClient(@PathVariable("id") Long id){
        return reservationRepository.findAllByOwner(id);
    }

    @GetMapping("/{id}")
    public Reservation Reservation(@PathVariable("id") String id){
        return reservationRepository.findFirstById(id);
    }

    @PostMapping("")
    public List<Reservation> addReservation(@RequestBody Reservation reservation)  {
       Reservation reservation1= reservationRepository.save(reservation);
        return reservationRepository.findAllByPitch(reservation1.getPitch());
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
