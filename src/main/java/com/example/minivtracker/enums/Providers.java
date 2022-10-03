package com.example.minivtracker.enums;

import java.util.ArrayList;
import java.util.List;

public enum Providers {
    NEWS_API(1, "NEWS_API", "https://newsapi.org/v2/everything?q=%s&apiKey=533dcc8d30ac4b538ab1a574a8f1643c"),
    MEDIA_STACK(2, "MEDIA_STACK", "http://api.mediastack.com/v1/news?keywords=%s&access_key=fff11203ff96d90e558ffdf1472fa13b");

    private final String name;
    private final String url;
    Providers(int i, final String name, final String url) {
        this.name = name;
        this.url = url;
    }

    public String getUrl() {
        return this.url;
    }

    public Providers getByName(String name) {
        for (Providers provider : Providers.values()) {
            if (provider.name.equals(name)) {
                return provider;
            }
        }
        return null;
    }

    public static List<String> getProviders() {
        List<String> listProviders = new ArrayList<>();
        for (Providers provider : Providers.values()) {
            listProviders.add(provider.name);
        }
        return listProviders;
    }
}
