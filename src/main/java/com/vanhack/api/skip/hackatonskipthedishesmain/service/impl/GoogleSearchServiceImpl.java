package com.vanhack.api.skip.hackatonskipthedishesmain.service.impl;

import com.vanhack.api.skip.hackatonskipthedishesmain.domain.NearbySearchResponse;
import com.vanhack.api.skip.hackatonskipthedishesmain.service.GoogleSearchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class GoogleSearchServiceImpl implements GoogleSearchService {

    @Value("${google.api.key}")
    private String googleKey;

    @Autowired
    RestTemplate restTemplate;

    @Override
    public NearbySearchResponse consultGoogle(String location, String radius, String type) {
        StringBuilder sb = new StringBuilder();

        sb.append("https://maps.googleapis.com/maps/api/place/nearbysearch/json?")
                .append("location=")
                .append(location)
                .append("&radius=")
                .append(radius)
                .append("&type=")
                .append(type)
                .append("&key=")
                .append(googleKey);


        ResponseEntity<NearbySearchResponse> forEntity = restTemplate.getForEntity(sb.toString(), NearbySearchResponse.class);
        return forEntity.getBody();
    };
}
