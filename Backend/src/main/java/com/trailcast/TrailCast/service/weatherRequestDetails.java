package com.trailcast.TrailCast.service;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Builder
@Setter
@Getter
public class weatherRequestDetails {
    private String city;
}
