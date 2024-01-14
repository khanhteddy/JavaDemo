package com.example.demo.service.impl;

import com.example.demo.dto.request.UserPostRequest;
import com.example.demo.properties.UploadConfigProperties;
import com.example.demo.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class UserServiceImpl implements UserService {

    @Autowired
    private UploadConfigProperties uploadConfigProperties;

    @Override
    public boolean saveUser(UserPostRequest userPostRequest) {
        log.info("SERVICE user save User");
        uploadConfigProperties.getMaxUploadTimes();
        return false;
    }

}
