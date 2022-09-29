package com.example.minivtracker.services.impl;

import com.example.minivtracker.config.ApiConfig;
import com.example.minivtracker.services.NewsapiService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Map;

@Slf4j
@Service
public class NewsapiServiceImpl implements NewsapiService {

    private final ApiConfig config;
    private final RestTemplate restTemplate;

    private final ObjectMapper mapper;

    public  NewsapiServiceImpl(final ApiConfig config, final RestTemplate restTemplate, final ObjectMapper mapper) {
        this.config = config;
        this.restTemplate = restTemplate;
        this.mapper = mapper;
    }

    @Override
    public Map<String, Object> getNewsFromNewsApi(String keyWord) {
        return doHttpCall(String.format(config.getNewsApiBaseUrl(), keyWord, config.getNewsApiKey()));
    }

    private Map<String, Object> doHttpCall(String url) {

        log.info("Realizando request para api {}", url);

        Map<String, Object> result;

        try {
            result = mapper.readValue(restTemplate.getForObject(url, String.class), Map.class);
        } catch (JsonProcessingException e) {
            log.error("Erro ao realizar parse dos dados", e);
            return null;
        }

        return result;
    }
}
