package com.sweettracker.websocketexample.domain;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
// https://velog.io/@leui9179/WebSocket%EC%9D%84-%EC%9D%B4%EC%9A%A9%ED%95%98%EC%97%AC-%EC%B1%84%ED%8C%85-%EA%B8%B0%EB%8A%A5-%EA%B5%AC%ED%98%84%ED%95%98%EA%B8%B0-1
@Getter
@Setter
@NoArgsConstructor
public class ChatMessage {

    private MessageType messageType;
    private String roomId;
    private String sender;
    private String message;

    @Builder
    public ChatMessage(MessageType messageType, String roomId, String sender, String message) {
        this.messageType = messageType;
        this.roomId = roomId;
        this.sender = sender;
        this.message = message;
    }

    public enum MessageType {
        ENTER, TALK, QUIT
    }
}
