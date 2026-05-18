package com.trailcast.service;

import com.trailcast.client.OpenWeatherClient;
import com.trailcast.model.entity.WeatherData;
import com.trailcast.model.mapper.WeatherMapper;
import org.springframework.stereotype.Service;

@Service
public class WeatherService {

    private final OpenWeatherClient openWeatherClient;

    public WeatherService(OpenWeatherClient openWeatherClient){
        this.openWeatherClient=openWeatherClient;
    }

    public WeatherData getWeather(String city) {
        var dto=openWeatherClient.getWeatherByCity(city);
        return WeatherMapper.toEntity(dto);
    }
}
