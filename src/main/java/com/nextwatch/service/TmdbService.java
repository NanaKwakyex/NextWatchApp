package com.nextwatch.service;

import java.net.http.HttpResponse;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

@Service
public class TmdbService {
    @Value("${tmdb.api.key}")
    private String apiKey;

    private static final String BASE_URL = "https://api.themoviedb.org/3/";

    public String getPopularMovies(){
        String url = BASE_URL +"movie/popular?api_key=" +apiKey;
        RestTemplate restTemplate = new RestTemplate();
        return restTemplate.getForObject(url, String.class);
    }
    
    public String getPopularShows(){
        String url = BASE_URL +"tv/popular?api_key=" + apiKey;
        RestTemplate restTemplate = new RestTemplate();
        return restTemplate.getForObject(url, String.class);
    }

    public String getSearchResults(String searchQuery){
        String url = BASE_URL + "search/multi?api_key=" + apiKey + "&query=" + searchQuery;
        RestTemplate restTemplate = new RestTemplate();
        try {
            return restTemplate.getForObject(url, String.class);
        } catch (HttpClientErrorException e) {
            return "failed to fetch search results: " + e.getMessage();
        }
        catch (Exception ex){
            return "An unexpected error has occured: " + ex.getMessage();
        }
    }

    public String getSpecificSearchResults(String searchQuery, String specific){
        String url = BASE_URL + "search/" + specific + "?api_key="+ apiKey + "&query" + searchQuery;
        RestTemplate restTemplate = new RestTemplate();
        try {
            return restTemplate.getForObject(url, String.class);
        } catch (HttpClientErrorException e) {
            return "failed to fetch search results: " + e.getMessage();
        }
        catch (Exception ex){
            return "An unexpected error has occured: " + ex.getMessage();
        }
    }

}
