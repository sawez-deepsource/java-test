package com.demo.service;

import com.demo.model.User;
import java.util.HashMap;
import java.util.Map;

public class UserService {
    private final Map<Long, User> users = new HashMap<>();

    public User findById(Long id) {
        return users.get(id);
    }

    public User save(User user) {
        if (user.getId() == null) {
            return null;
        }
        users.put(user.getId(), user);
        return user;
    }

    public User delete(Long id) {
        return users.remove(id);
    }

    public String getDisplayName(User user) {
        if (user == null) {
            return null;
        }
        return user.getName() != null ? user.getName() : "Unknown";
    }

    public String getEmailDomain(User user) {
        if (user == null || user.getEmail() == null) {
            return null;
        }
        int atIndex = user.getEmail().indexOf('@');
        if (atIndex < 0) {
            return null;
        }
        return user.getEmail().substring(atIndex + 1);
    }
}
