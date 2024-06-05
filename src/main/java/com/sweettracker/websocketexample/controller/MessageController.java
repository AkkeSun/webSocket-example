package com.sweettracker.websocketexample.controller;

import com.sweettracker.websocketexample.service.MessageService;
import lombok.RequiredArgsConstructor;
import org.springframework.messaging.handler.annotation.DestinationVariable;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
class MessageController {

    private final MessageService messageService;

    @MessageMapping("/send/{roomId}")
    public void sendMessage(@DestinationVariable String roomId, String message) {
        messageService.send(roomId, message);
    }
}
