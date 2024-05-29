package com.sweettracker.websocketexample.config;

import com.sweettracker.websocketexample.domain.ChatMessage;
import com.sweettracker.websocketexample.service.ChatServiceImpl;
import com.sweettracker.websocketexample.util.Util;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.handler.TextWebSocketHandler;


@Slf4j
@Component
@RequiredArgsConstructor
public class WebSocketCatHandler extends TextWebSocketHandler {

    private final ChatServiceImpl chatService;

    /*
    TODO
        1. 방에대한 정보롤 DB 로 관리
        2. 주고받은 메시지를 DB로 관리
        3. 서버를 재시동하는 경우 서버가 자동으로 세션을 맺어준다
     */
    @Override
    public void handleTextMessage(WebSocketSession session, TextMessage message) {
        String payload = message.getPayload();
        ChatMessage chatMessage = Util.Chat.resolvePayload(payload);
        chatService.handleAction(chatMessage.getRoomId(), session, chatMessage);
    }
}
