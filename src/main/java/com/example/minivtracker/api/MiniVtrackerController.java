package com.example.minivtracker.api;

import com.example.minivtracker.services.NewsapiService;
import com.fasterxml.jackson.core.JsonProcessingException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
public class MiniVtrackerController {

    public final NewsapiService newsapiService;

    @Autowired
    public MiniVtrackerController(final NewsapiService newsapiService) {
        this.newsapiService = newsapiService;
    }

    @GetMapping("/news")
    public Map<String, Object> getNews (@RequestParam String keyWord) throws JsonProcessingException {
        return newsapiService.getNewsFromNewsApi(keyWord);
    }
}
