package com.trailcast.controller;

import com.trailcast.model.entity.WeatherData;
import com.trailcast.service.WeatherService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class WeatherViewController {
    public final WeatherService weatherService;

    public WeatherViewController(WeatherService weatherService){
        this.weatherService=weatherService;
    }
    @GetMapping("/")
    public String home(){
        return "index";
    }

    @GetMapping("/weather")
    public String displayWeather(@RequestParam String city, Model model){
        try{
            WeatherData weatherData = weatherService.getWeather(city);

            model.addAttribute("city",weatherData.getCityName());
            model.addAttribute("country",weatherData.getCountry());
            model.addAttribute("weatherDescription",weatherData.getDescription());
            model.addAttribute("temperature",weatherData.getTemperature());
            model.addAttribute("humidity",weatherData.getHumidity());
            model.addAttribute("windSpeed",weatherData.getWindSpeed());
            return "weather";
        } catch (Exception e) {
            model.addAttribute("error", "City not found or an API error occurred.");
            return "weather";
        }
    }
}
