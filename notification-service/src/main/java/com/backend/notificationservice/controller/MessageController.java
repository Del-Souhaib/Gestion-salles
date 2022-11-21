package com.backend.notificationservice.controller;

import com.backend.notificationservice.Repository.MessageRepository;
import com.backend.notificationservice.model.Message;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/messages")
public class MessageController {

    @Autowired
    private MessageRepository messageRepository;

    @GetMapping("")
    public List<Message> MessageList() {
        return messageRepository.findAll();
    }

    @GetMapping("/{id}")
    public Message Message(@PathVariable("id") Long id) {
        return messageRepository.getOne(id);
    }

    @PostMapping("")
    public void addMessage(@RequestBody Message message) {
        messageRepository.save(message);
    }

    @PutMapping("")
    public void updateMessage(@RequestBody Message message) {
        messageRepository.save(message);
    }


    @DeleteMapping("/{id}")
    public void deleteMessage(@PathVariable("id") Long id) {
        messageRepository.deleteById(id);
    }
}

