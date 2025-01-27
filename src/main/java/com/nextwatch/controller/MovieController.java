package com.nextwatch.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.nextwatch.service.TmdbService;

@RestController
@RequestMapping("/movies")
public class MovieController {
    @Autowired
    private TmdbService tmdbService;

    @GetMapping("/popular")
    public ResponseEntity<?> getPopularMovies() {
        return ResponseEntity.ok(tmdbService.getPopularMovies());
    }
}
