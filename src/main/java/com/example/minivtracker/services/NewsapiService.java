package com.example.minivtracker.services;

import com.example.minivtracker.dto.BaseRequestDto;

import java.util.Map;

public interface NewsapiService {

    /**
     * Método que realiza chamada para a API de notícias
     * @param request estrutura padrão do request
     * @return map com os dados das noticias e metadados
     */
    Map<String, Object> getNewsFromApis(BaseRequestDto request);
}
