package com.trailcast.TrailCast.service;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.trailcast.TrailCast.model.WeatherEntity;
import lombok.*;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@JsonIgnoreProperties(ignoreUnknown = true)
public class OpenWeatherResponseEntity {
    @JsonProperty("weather")
    private WeatherEntity[] weather;

}
