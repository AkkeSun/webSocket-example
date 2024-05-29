package com.sweettracker.websocketexample.service;

import com.sweettracker.websocketexample.domain.ChatMessage;
import com.sweettracker.websocketexample.domain.ChatRoom;
import com.sweettracker.websocketexample.repository.ChatRepository;
import com.sweettracker.websocketexample.util.Util;
import java.util.List;
import java.util.UUID;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;

@Service
@RequiredArgsConstructor
public class ChatServiceImpl {

    private final ChatRepository chatRepository;

    public List<ChatRoom> findAll() {
        return chatRepository.findAll();
    }

    public ChatRoom findRoomById(String roomId) {
        return chatRepository.findById(roomId);
    }

    public ChatRoom createRoom(String name) {
        String roomId = UUID.randomUUID().toString();
        ChatRoom chatRoom = ChatRoom.of(roomId, name);
        chatRepository.save(roomId, chatRoom);
        return chatRoom;
    }

    public void handleAction(String roomId, WebSocketSession session,
        ChatMessage chatMessage) {
        ChatRoom room = findRoomById(roomId);

        if (isEnterRoom(chatMessage)) {
            room.join(session);
            chatMessage.setMessage(chatMessage.getSender() + "님 환영합니다.");
        }

        TextMessage textMessage = Util.Chat.resolveTextMessage(chatMessage);
        room.sendMessage(textMessage);
    }

    private boolean isEnterRoom(ChatMessage chatMessage) {
        return chatMessage.getMessageType().equals(ChatMessage.MessageType.ENTER);
    }
}