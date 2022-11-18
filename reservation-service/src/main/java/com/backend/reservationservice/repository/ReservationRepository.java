package com.backend.reservationservice.repository;

import com.backend.reservationservice.model.Reservation;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ReservationRepository extends MongoRepository<Reservation,String> {
}
