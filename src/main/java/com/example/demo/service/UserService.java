package com.example.demo.service;

import com.example.demo.dto.request.UserPostRequest;

public interface UserService {

    boolean saveUser(UserPostRequest userPostRequest);
}
