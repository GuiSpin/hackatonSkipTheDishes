package com.vanhack.api.skip.hackatonskipthedishesmain.service;

import com.vanhack.api.skip.hackatonskipthedishesmain.domain.NearbySearchResponse;

public interface NearbySearchMessageService {
    void sendNearbySearchMessageRabbit(NearbySearchResponse nearbySearchResponse);
}
