package com.backend.reservationservice.repository;

import com.backend.reservationservice.model.Payment;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface PaymentRepository extends MongoRepository<Payment,String> {

    Payment findFirstById(String id);
}
