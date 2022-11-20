package com.backend.reservationservice.controller;

import com.backend.reservationservice.model.Payment;
import com.backend.reservationservice.model.Reservation;
import com.backend.reservationservice.repository.PaymentRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/api/payments")
public class PaymentController {

    @Autowired
    private PaymentRepository paymentRepository;

    @GetMapping("")
    public List<Payment> PaymentList(){
        return paymentRepository.findAll();
    }

    @GetMapping("/{id}")
    public Payment Payment(@PathVariable("id") String id){
        return paymentRepository.findFirstById(id);
    }

    @PostMapping("")
    public void addPayment(@RequestBody Payment payment ) throws IOException {
        paymentRepository.save(payment);
    }

    @PutMapping("")
    public void updatePayment(@RequestBody Payment payment) throws IOException {
        paymentRepository.save(payment);
    }


    @DeleteMapping("/{id}")
    public void deletePayment(@PathVariable("id") String id)  {
        paymentRepository.deleteById(id);
    }

}
