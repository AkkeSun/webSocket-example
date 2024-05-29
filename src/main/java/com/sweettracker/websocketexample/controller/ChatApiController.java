package com.sweettracker.websocketexample.controller;

import com.sweettracker.websocketexample.domain.ChatRoom;
import com.sweettracker.websocketexample.service.ChatServiceImpl;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

// https://brilliantdevelop.tistory.com/162
@RestController
@RequiredArgsConstructor
class ChatApiController {
    private final ChatServiceImpl chatService;

    @GetMapping("/api/chat")
    List<ChatRoom> getChatList() {
        return chatService.findAll();
    }

    @PostMapping("/api/chat")
    ChatRoom registerChatRoom(@RequestParam String roomName) {
        return chatService.createRoom(roomName);
    }
}
