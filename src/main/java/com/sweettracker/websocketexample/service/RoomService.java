package com.sweettracker.websocketexample.service;

import lombok.RequiredArgsConstructor;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class RoomService {

    private final RedisTemplate<String, String> redisTemplate;
    private static final String ROOMS_KEY = "message::rooms";

    public void createTopic(String roomId) {
        if (Boolean.FALSE.equals(redisTemplate.opsForSet().isMember(ROOMS_KEY, roomId))) {
            redisTemplate.opsForSet().add(ROOMS_KEY, roomId);
            System.out.println("Created room: " + roomId);
        } else {
            System.out.println("Room already exists: " + roomId);
        }
    }
}
