package com.nextwatch.controller;

import com.nextwatch.service.TmdbService;

public class SearchController {
    private TmdbService tmdbService;
    public String searchQ(String query, String type){
        if(query.equals("")){
            return "Query parameter is required";
        }
        String results = "";
        switch(type){
            case "Movie":
            results = tmdbService.getSpecificSearchResults(query, "Movie");
            break;
            case "TV":
            results = tmdbService.getSpecificSearchResults(query, "TV");
            break;
            default:
            results = tmdbService.getSearchResults(query);
        }
        return results;
    }
    
}
