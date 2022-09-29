package com.example.minivtracker.services;

import java.util.Map;

public interface NewsapiService {

    /**
     * Método que realiza chamada para a API de notícias
     * @param keyWord palavra chave que será buscada
     * @return map com os dados das noticias e metadados
     */
    Map<String, Object> getNewsFromNewsApi(String keyWord);
}
