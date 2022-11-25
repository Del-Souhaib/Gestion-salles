package com.backend.rabbitmqqueue.controller;


import com.backend.rabbitmqqueue.config.Receiver;
import lombok.AllArgsConstructor;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/api/queues")
@AllArgsConstructor
public class MessageQueueController {
    private final RabbitTemplate rabbitTemplate;
    private final Receiver receiver;



    @PostMapping("/send")
    public void sendQueue(){
        rabbitTemplate.convertAndSend("notification-exchange", "api.notifications.*", "Hello from RabbitMQ!");
    }



}
