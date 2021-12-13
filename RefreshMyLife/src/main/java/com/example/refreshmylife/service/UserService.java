package com.example.refreshmylife.service;

import com.example.refreshmylife.model.User;

public interface UserService {
    User findUserByUserID(String userId);
}
