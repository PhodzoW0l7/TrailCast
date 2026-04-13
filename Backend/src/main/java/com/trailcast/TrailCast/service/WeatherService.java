package com.trailcast.TrailCast.service;

import com.trailcast.TrailCast.dto.CityCoordinates;
import com.trailcast.TrailCast.dto.CityWeather;
import com.trailcast.TrailCast.dto.WeatherResponse;
import com.trailcast.TrailCast.model.GeocodingProvider;
import com.trailcast.TrailCast.resource.WeatherProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class WeatherService {

    private GeocodingProvider geocodingProvider;
    private GeocodingTransformer geocodingTransformer;
    private WeatherProvider weatherProvider;
    private OpenWeatherTransformer openWeatherTransformer;

    @Autowired
    public WeatherService(final GeocodingProvider geocodingProvider, GeocodingTransformer geocodingTransformer,
                          final WeatherProvider weatherProvider, OpenWeatherTransformer openWeatherTransformer){
        this.geocodingProvider=geocodingProvider;
        this.geocodingTransformer=geocodingTransformer;
        this.weatherProvider=weatherProvider;
        this.openWeatherTransformer=openWeatherTransformer;
    }

    public WeatherResponse getWeather(final weatherRequestDetails weatherRequestDetails) throws Exception {

        final CityCoordinates cityCoordinates=geocodingTransformer.
                transferToDomain(geocodingProvider.getCoordinates(weatherRequestDetails));

        final CityWeather cityWeather= openWeatherTransformer.
                transformToDomain (weatherProvider.getWeather(cityCoordinates));
        return openWeatherTransformer.transformToEntity(cityWeather);

    }
}
