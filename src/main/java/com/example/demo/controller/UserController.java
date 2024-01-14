package com.example.demo.controller;

import com.example.demo.dto.request.UserPostRequest;
import com.example.demo.dto.response.TestDto;
import com.example.demo.properties.UploadConfigProperties;
import com.example.demo.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

import java.util.logging.Logger;

@RestController
@Slf4j
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    private UploadConfigProperties uploadConfigProperties;

    @Value("${upload-config.max-file-size}")
    private String maxFileSize2;

    @GetMapping("/user")
    public String getDetail(){
        return "Hello A";
    }

    @PostMapping("/user")
    public String saveUser(@RequestBody UserPostRequest userPostRequest){
        log.info("input : {}", userPostRequest.toString());
        userService.saveUser(userPostRequest);

        String maxFileSize = uploadConfigProperties.getMaxFileSize();
        int maxUploadTimes = uploadConfigProperties.getMaxUploadTimes();

        log.info("log conifg ne : {} , {} , {}", maxFileSize, maxUploadTimes, maxFileSize2);
        return "da save";
    }

    @GetMapping("/test-c")
    public String testController(){
        TestDto testDto = new TestDto();
        testDto.setId(10);
        testDto.setName("hahah");

        String string = testDto.toString();
        log.info(" tesst : {}", string);
        return "";
    }
}
