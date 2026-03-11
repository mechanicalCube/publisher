package com.bto.publisher.controller;

import com.bto.publisher.model.Notification;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.web.bind.annotation.*;

@RestController
public class MessageController {


    private final RabbitTemplate rabbitTemplate;

    public MessageController(RabbitTemplate rabbitTemplate) {
        this.rabbitTemplate = rabbitTemplate;
    }


    @GetMapping("/message")
    public String sendMessage(@RequestParam String message){
        rabbitTemplate.convertAndSend("kurs", message);
        return "wrzucono wiadomość na RabbitMq";
    }

    //localhost:8762/message?message=kon

    //https://customer.cloudamqp.com/instance

    @PostMapping("/notification")
    public String sendNotification(@RequestBody Notification notification){
        rabbitTemplate.convertAndSend("kurs", notification);
        return "wrzucono notyfikacje  na RabbitMq";
    }

}
