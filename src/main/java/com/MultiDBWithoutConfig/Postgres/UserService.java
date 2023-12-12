package com.MultiDBWithoutConfig.Postgres;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

	@Autowired
    private UserRepository repository;

    public void saveUser(ChatUser user) {
        user.setStatus(Status.ONLINE);
        repository.save(user);
    }

    public void disconnect(ChatUser user) {
        var storedUser = repository.findById(user.getNickName()).orElse(null);        
        if (storedUser != null) {
            storedUser.setStatus(Status.OFFLINE);
            repository.save(storedUser);
        }
    }

    public List<ChatUser> findConnectedUsers() {
        return repository.findAllByStatus(Status.ONLINE);
    }
}
