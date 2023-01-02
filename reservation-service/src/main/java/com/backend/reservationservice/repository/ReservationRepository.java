package com.backend.reservationservice.repository;

import com.backend.reservationservice.model.Reservation;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;
import java.util.List;

public interface ReservationRepository extends MongoRepository<Reservation,String> {

    Reservation findFirstById(String id);

    List<Reservation> findAllByPitch(Long id);

    List<Reservation> findAllByOwner(Long id);

    boolean existsAllByDateReservation(@DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss") Date date);

}
