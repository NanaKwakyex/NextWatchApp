package com.nextwatch.nextwatch.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class TmdbService {
    @Value("${tmdb.api.key}")
    private String apiKey;

    private static final String BASE_URL = "";

    public String getPopularMovies(){
        String url = BASE_URL +"movie/popular?api_key=" +apiKey;
        RestTemplate restTemplate = new RestTemplate();
        return restTemplate.getForObject(url, String.class);
    }
    
}
