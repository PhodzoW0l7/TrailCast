package com.trailcast.TrailCast.resource;

import com.trailcast.TrailCast.dto.WeatherResponse;
import com.trailcast.TrailCast.service.WeatherService;
import com.trailcast.TrailCast.service.weatherRequestDetails;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1")
public class WeatherResource {

    private WeatherService weatherService;

    @Autowired
    public WeatherResource(final WeatherService weatherService){
        this.weatherService=weatherService;
    }

    @GetMapping("/weather/{city}")
    public @ResponseBody WeatherResponse(@PathVariable("city")String city){
        final weatherRequestDetails weatherRequestDetails= com.trailcast.TrailCast.service.weatherRequestDetails.builder()
                .city(city)
                .build();

        return weatherService.getWeather(weatherRequestDetails);
    }
}
