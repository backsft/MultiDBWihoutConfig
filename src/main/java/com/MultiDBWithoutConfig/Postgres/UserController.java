package com.MultiDBWithoutConfig.Postgres;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class UserController {

	@Autowired
    private UserService userService;

    @MessageMapping("/user.addUser")
    @SendTo("/user/public")
    public ChatUser addUser(
            @Payload ChatUser user
    ) {
        userService.saveUser(user);
        return user;
    }

    @MessageMapping("/user.disconnectUser")
    @SendTo("/user/public")
    public ChatUser disconnectUser(
            @Payload ChatUser user
    ) {
        userService.disconnect(user);
        return user;
    }

    @GetMapping("/users")
    public ResponseEntity<List<ChatUser>> findConnectedUsers() {
        return ResponseEntity.ok(userService.findConnectedUsers());
    }
}
