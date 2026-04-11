package com.trailcast.TrailCast.service;

import com.trailcast.TrailCast.dto.CityCoordinates;
import com.trailcast.TrailCast.dto.WeatherResponse;
import com.trailcast.TrailCast.model.GeocodingProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class WeatherService {

    private GeocodingProvider geocodingProvider;

    @Autowired
    public WeatherService(final GeocodingProvider geocodingProvider){
        this.geocodingProvider=geocodingProvider;
    }

    public WeatherResponse getWeather(final weatherRequestDetails weatherRequestDetails){

        final CityCoordinates cityCoordinates=geocodingProvider.getCoordinates(weatherRequestDetails);

    }
}
