package com.example.minivtracker.services;

import com.example.minivtracker.config.ApiConfig;
import com.example.minivtracker.services.impl.NewsapiServiceImpl;
import com.example.minivtracker.testMass.TestMass;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.web.client.RestTemplate;

import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.when;

public class NewsapiServiceImplTest {

    @Mock
    private RestTemplate restTemplate;

    @Mock
    private ApiConfig config;

    private NewsapiService service;

    @BeforeEach
    public void setup() {
        MockitoAnnotations.openMocks(this);
        this.service = new NewsapiServiceImpl(config, restTemplate, new ObjectMapper());
    }

    @Test
    public void shouldRetrieveIfResponseOK(){
        when(config.getNewsApiBaseUrl()).thenReturn("http://httbbin?param=%s&param=%s");
        when(config.getNewsApiKey()).thenReturn("any");
        when(restTemplate.getForObject(anyString(), eq(String.class))).thenReturn(TestMass.VALID_NEWS_API_RESPONSE);

        Map<String, Object> response = service.getNewsFromNewsApi("any");

        assertTrue(response.get("status").equals("OK"));
        assertTrue(response.get("totalResults").equals(0));
    }

    @Test
    public void shouldNotRetrieveIfResponseNotOK(){
        when(config.getNewsApiBaseUrl()).thenReturn("http://httbbin?param=%s&param=%s");
        when(config.getNewsApiKey()).thenReturn("any");
        when(restTemplate.getForObject(anyString(), eq(String.class))).thenReturn(TestMass.INVALID_NEWS_API_RESPONSE);

        Map<String, Object> response = service.getNewsFromNewsApi("any");

        assertNull(response);
    }
}
