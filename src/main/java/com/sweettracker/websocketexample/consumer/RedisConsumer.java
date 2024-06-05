package com.sweettracker.websocketexample.consumer;

import lombok.RequiredArgsConstructor;
import org.springframework.data.redis.connection.Message;
import org.springframework.data.redis.connection.MessageListener;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class RedisConsumer implements MessageListener {

    private final SimpMessagingTemplate messagingTemplate;

    @Override
    public void onMessage(Message message, byte[] pattern) {
        String topic = new String(message.getChannel());
        String messageStr = new String(message.getBody());
        String key = "/topic/" + topic.replace("room.", "");
        // /topic/{roomId} 를 구독하는 사용자에게 메시지 전송
        messagingTemplate.convertAndSend(key, messageStr);
    }
}
