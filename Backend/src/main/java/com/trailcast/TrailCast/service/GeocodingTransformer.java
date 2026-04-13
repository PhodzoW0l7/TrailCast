package com.trailcast.TrailCast.service;

import com.trailcast.TrailCast.dto.CityCoordinates;
import com.trailcast.TrailCast.dto.GeocodingCoordinatesEntity;
import org.springframework.stereotype.Service;

@Service
public class GeocodingTransformer {

    // Change the parameter type to GeocodingCoordinatesEntity
    public CityCoordinates transferToDomain(final GeocodingCoordinatesEntity entity) {
        return CityCoordinates.builder()
                .latitude(entity.getLatitude())
                .longitude(entity.getLongitude())
                .build();
    }
}