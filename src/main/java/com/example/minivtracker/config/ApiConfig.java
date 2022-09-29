package com.example.minivtracker.config;

import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

@Data
@Slf4j
@Configuration
public class ApiConfig implements InitializingBean {

    @Value("${news.api.base.url:}")
    private String newsApiBaseUrl;

    @Value("${news.api.key:}")
    private String newsApiKey;

    @Override
    public void afterPropertiesSet() throws Exception {
        if(newsApiKey == "") {
            log.error("ApiKey não informada requests não funcionarão");
        }
    }
}
