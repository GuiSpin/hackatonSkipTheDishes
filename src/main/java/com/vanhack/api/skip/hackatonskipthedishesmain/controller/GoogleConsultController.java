package com.vanhack.api.skip.hackatonskipthedishesmain.controller;


import com.vanhack.api.skip.hackatonskipthedishesmain.domain.NearbySearchResponse;
import com.vanhack.api.skip.hackatonskipthedishesmain.repository.NearbySearchRepository;
import com.vanhack.api.skip.hackatonskipthedishesmain.service.GoogleSearchService;
import com.vanhack.api.skip.hackatonskipthedishesmain.service.NearbySearchMessageService;
import com.vanhack.api.skip.hackatonskipthedishesmain.service.NearbySearchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("/google/consult")
public class GoogleConsultController {


    @Autowired
    GoogleSearchService googleSearchService;

    @Autowired
    NearbySearchService nearbySearchService;

    @Autowired
    NearbySearchMessageService nearbySearchMessageService;

    @GetMapping("/summarized")
    @ResponseBody
    public NearbySearchResponse summarizedConsult(@RequestParam String location,
                                  @RequestParam String radius,
                                  @RequestParam String type) {

        NearbySearchResponse nearbySearchResponse = googleSearchService.consultGoogle(location, radius, type);

        nearbySearchService.saveNearbySearchresponse(nearbySearchResponse);

        nearbySearchMessageService.sendNearbySearchMessageRabbit(nearbySearchResponse);

        return nearbySearchResponse;
    }
}
