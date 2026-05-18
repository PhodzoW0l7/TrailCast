package com.trailcast.model.dto;

import java.util.List;

public record WeatherResponseDTO (
    String name,
    String sys,
    List<Weather> weather,
    Main main,
    Wind wind
){
    public record sys(String country){}
    public record Weather(int id,String description){}
    public record Main(double temp, int humidity){}
    public record Wind(double speed){}
}
