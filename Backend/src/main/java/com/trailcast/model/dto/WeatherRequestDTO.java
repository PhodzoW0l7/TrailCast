package com.trailcast.model.dto;

import jakarta.validation.constraints.NotBlank;

public class WeatherRequestDTO {
    @NotBlank(message = "Please enter a valid place or address")
    String city;
}
