package com.example.minivtracker.api;

import com.example.minivtracker.dto.BaseRequestDto;
import com.example.minivtracker.enums.Providers;
import com.example.minivtracker.services.NewsapiService;
import com.fasterxml.jackson.core.JsonProcessingException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
public class MiniVtrackerController {

    public final NewsapiService newsapiService;

    @Autowired
    public MiniVtrackerController(final NewsapiService newsapiService) {
        this.newsapiService = newsapiService;
    }

    @PostMapping("/news")
    public Map<String, Object> getNews (@RequestBody BaseRequestDto request) {
        return newsapiService.getNewsFromApis(request);
    }

    @GetMapping("/providers")
    public List<String> getProviders() {
        return Providers.getProviders();
    }
}
