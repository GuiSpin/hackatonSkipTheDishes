package com.vanhack.api.skip.hackatonskipthedishesmain.service.impl;

import com.vanhack.api.skip.hackatonskipthedishesmain.domain.NearbySearchResponse;
import com.vanhack.api.skip.hackatonskipthedishesmain.repository.NearbySearchRepository;
import com.vanhack.api.skip.hackatonskipthedishesmain.service.NearbySearchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class NearbySearchServiceImpl implements NearbySearchService {

    @Autowired
    NearbySearchRepository nearbySearchRepository;

    @Override
    public void saveNearbySearchresponse(NearbySearchResponse nearbySearchResponse) {
        nearbySearchRepository.save(nearbySearchResponse);
    }
}
