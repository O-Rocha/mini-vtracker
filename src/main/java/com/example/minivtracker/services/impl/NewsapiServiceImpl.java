package com.example.minivtracker.services.impl;

import com.example.minivtracker.dto.BaseRequestDto;
import com.example.minivtracker.enums.Providers;
import com.example.minivtracker.services.NewsapiService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.Map;

@Slf4j
@Service
public class NewsapiServiceImpl implements NewsapiService {

    private final RestTemplate restTemplate;

    private final ObjectMapper mapper;

    public  NewsapiServiceImpl(final RestTemplate restTemplate, final ObjectMapper mapper) {
        this.restTemplate = restTemplate;
        this.mapper = mapper;
    }

    @Override
    public Map<String, Object> getNewsFromApis(BaseRequestDto request) {
        Map<String,Object> result = new HashMap<>();
        for (String provider : request.getProviders()) {
            if (Providers.getProviders().contains(provider)) {
                Providers aux = Providers.valueOf(provider);
                String url = String.format(aux.getUrl(), request.getKeyWord());
                result.put(provider, doHttpCall(url));
            } else {
                log.error("Provedor -> {} não encontrado na lista atual", provider);
            }
        }
        return result;
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
