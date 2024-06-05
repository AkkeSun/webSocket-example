package com.sweettracker.websocketexample.controller;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
class RoomController {

    @PostMapping("/rooms")
    public void makeRoom(@RequestParam String roomId) {
        //..
    }

    @DeleteMapping("/rooms")
    public void deleteRoom(@RequestParam String roomId) {
        //..
    }

    @GetMapping("/rooms")
    public void findRoomList(@RequestParam String roomId) {
        //..
    }
}
