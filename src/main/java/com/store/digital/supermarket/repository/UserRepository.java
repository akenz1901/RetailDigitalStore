package com.store.digital.supermarket.repository;

import com.store.digital.supermarket.domain.User;

import java.util.HashMap;
import java.util.Map;

public class UserRepository {

    Long defaultId = 0L;

    private Map<Long, User> users = new HashMap<>();

    public  Map<Long, User> getAllUsers(){
        return users;
    }

    public User save(User user){
        defaultId++;
        user.setId(defaultId);
        users.put(user.getId(), user);
        return user;
    }

}
