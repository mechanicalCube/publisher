package com.bto.publisher.controller;

import com.bto.publisher.service.NotificationService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MessageController {

    private final NotificationService notificationService;

    public MessageController(NotificationService notificationService) {
        this.notificationService = notificationService;
    }

    @GetMapping("/notifications")
    public String sendStudentNotification(@RequestParam Long studentId) {
        notificationService.sendStudentNotification(studentId);
        return "Wiadomość została wysłana do studenta o id: " + studentId;
    }
}
//    private final RabbitTemplate rabbitTemplate;
//
//    public MessageController(RabbitTemplate rabbitTemplate) {
//        this.rabbitTemplate = rabbitTemplate;
//    }
//
//
//    @GetMapping("/message")
//    public String sendMessage(@RequestParam String message){
//        rabbitTemplate.convertAndSend("kurs", message);
//        return "wrzucono wiadomość na RabbitMq";
//    }
//
//    //localhost:8762/message?message=kon
//
//    //https://customer.cloudamqp.com/instance
//
//    @PostMapping("/notification")
//    public String sendNotification(@RequestBody Notification notification){
//        rabbitTemplate.convertAndSend("kurs", notification);
//        return "wrzucono notyfikacje  na RabbitMq";
//    }


