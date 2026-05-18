package com.trailcast.model.mapper;

import com.trailcast.model.dto.WeatherResponseDTO;
import com.trailcast.model.entity.WeatherData;

public final class WeatherMapper {

    private WeatherMapper(){}

    public static WeatherData toEntity(WeatherResponseDTO dto){
        var weather=dto.weather() !=null&& !dto.weather().isEmpty() ? dto.weather().getFirst() :null;

        return new WeatherData(
                dto.name(),
                dto.sys() !=null ? dto.sys():"",
                weather !=null ? weather.description() : "",
                dto.main() !=null ? dto.main().temp() : 0.0,
                dto.main() !=null ? dto.main().humidity(): 0,
                dto.wind() !=null ?dto.wind().speed() : 0.0
        );

    }
}
