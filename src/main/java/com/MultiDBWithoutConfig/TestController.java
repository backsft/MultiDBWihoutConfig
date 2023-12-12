package com.MultiDBWithoutConfig;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.MultiDBWithoutConfig.Postgres.ChatUser;
import com.MultiDBWithoutConfig.Postgres.UserRepository;

@RestController
@RequestMapping("/test")
public class TestController {

	@Autowired
	private UserRepository repository;

	@PostMapping("/insertTest")
	public ChatUser insertTest(@RequestBody ChatUser chatUser) {

		ChatUser chatUser2 = repository.save(chatUser);

		return chatUser2;

	}

	@GetMapping("/username/{nickName}")
	public ChatUser getChatUser(@PathVariable String nickName) {
		return repository.findById(nickName).orElse(null);
	}

}
