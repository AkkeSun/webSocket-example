package com.sweettracker.websocketexample.service;

import com.sweettracker.websocketexample.domain.ChatMessage;
import com.sweettracker.websocketexample.domain.ChatRoom;
import java.util.List;
import org.springframework.web.socket.WebSocketSession;

public interface ChatService {

    List<ChatRoom> findAll();

    ChatRoom registerRoom(String roomName);

    void sendMessage(ChatMessage chatMessage, WebSocketSession session);

    void enterRoom(ChatMessage chatMessage, WebSocketSession session);

    void quitRoom(ChatMessage chatMessage, WebSocketSession session);
}
