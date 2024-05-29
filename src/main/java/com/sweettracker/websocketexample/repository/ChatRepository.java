package com.sweettracker.websocketexample.repository;

import com.sweettracker.websocketexample.domain.ChatRoom;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

@Repository
public class ChatRepository {

    private final Map<String, ChatRoom> chatRooms =
        new LinkedHashMap<>();

    public void save(String roomId, ChatRoom chatRoom) {
        chatRooms.put(roomId, chatRoom);
    }

    public ChatRoom findById(String roomId) {
        return chatRooms.get(roomId);
    }

    public List<ChatRoom> findAll() {
        return new ArrayList<>(chatRooms.values());
    }
}
