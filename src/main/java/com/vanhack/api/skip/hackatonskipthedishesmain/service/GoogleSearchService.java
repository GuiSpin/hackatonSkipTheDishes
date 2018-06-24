package com.vanhack.api.skip.hackatonskipthedishesmain.service;

import com.vanhack.api.skip.hackatonskipthedishesmain.domain.NearbySearchResponse;

public interface GoogleSearchService {
    NearbySearchResponse consultGoogle(String location, String radius, String type);
}
