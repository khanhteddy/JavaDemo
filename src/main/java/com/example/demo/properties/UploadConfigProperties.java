package com.example.demo.properties;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ConfigurationProperties(prefix = "upload-config")
@Configuration
public class UploadConfigProperties {
    private String maxFileSize;
    private int maxUploadTimes;
}
