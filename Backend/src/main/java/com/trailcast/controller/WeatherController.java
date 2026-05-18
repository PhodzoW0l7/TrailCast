package com.trailcast.controller;

import com.trailcast.model.entity.WeatherData;
import com.trailcast.service.WeatherService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/weather")
public class WeatherController {
    private final WeatherService weatherService;

    public WeatherController(WeatherService weatherService){
        this.weatherService=weatherService;
    }

    @GetMapping
    public WeatherData getWeather(@RequestParam String city){
        return weatherService.getWeather(city);
    }
}
