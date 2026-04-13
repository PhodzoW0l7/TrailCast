package com.trailcast.TrailCast.model;

import com.trailcast.TrailCast.dto.GeocodingCoordinatesEntity;
import com.trailcast.TrailCast.service.weatherRequestDetails; // Note: Recommended to rename to WeatherRequestDetails
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpStatusCodeException;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponents;
import org.springframework.web.util.UriComponentsBuilder;

@Service
public class GeocodingProvider {

    @Value("${api-key.geocoding.value}")
    private String apiKey;

    // Fixed typo: Moved '$' inside the curly braces
    @Value("${api-key.geocoding.url}")
    private String geocodingUrl;

    public GeocodingCoordinatesEntity getCoordinates(final weatherRequestDetails weatherRequestDetails) throws Exception {

        RestTemplate restTemplate = new RestTemplate();

        // CHANGED: Variable type matches the return type
        final ResponseEntity<GeocodingCoordinatesEntity[]> responseEntity;

        HttpEntity<String> requestEntity = new HttpEntity<>(null, null);

        UriComponents uriBuilder = UriComponentsBuilder.fromHttpUrl(geocodingUrl)
                .queryParam("q", weatherRequestDetails.getCity())
                .queryParam("limit", "1")
                .queryParam("appid", apiKey)
                .build();

        try {
            responseEntity = restTemplate.exchange(
                    uriBuilder.toUriString(),
                    HttpMethod.GET,
                    requestEntity,
                    GeocodingCoordinatesEntity[].class // Correctly using the DTO class
            );
        } catch (HttpStatusCodeException e) {
            throw new Exception(e.getMessage());
        }

        // Return the first element. Type now matches the method signature!
        if (responseEntity.getBody() != null && responseEntity.getBody().length > 0) {
            return responseEntity.getBody()[0];
        } else {
            throw new Exception("No coordinates found for city: " + weatherRequestDetails.getCity());
        }
    }
}