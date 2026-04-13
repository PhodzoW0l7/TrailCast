package com.trailcast.TrailCast.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

@Builder
@AllArgsConstructor
@Getter
@Setter
@NoArgsConstructor
public class WeatherEntity {
    @JsonProperty("id")
    private String id;
    @JsonProperty("main")
    private String main;
    @JsonProperty("description")
    private String description;
    @JsonProperty("icon")
    private String icon;
}
