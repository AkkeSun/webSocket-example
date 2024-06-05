package com.sweettracker.websocketexample.service;

import lombok.RequiredArgsConstructor;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MessageService {

    private final RedisTemplate<String, String> redisTemplate;

    public void send(String roomId, String message) {
        String channel = "room." + roomId;
        redisTemplate.convertAndSend(channel, message);
        System.out.println("send : " + message);
        // save message
    }
}
