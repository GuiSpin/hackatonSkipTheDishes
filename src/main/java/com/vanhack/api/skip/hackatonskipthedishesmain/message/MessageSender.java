package com.vanhack.api.skip.hackatonskipthedishesmain.message;

import com.vanhack.api.skip.hackatonskipthedishesmain.domain.NearbySearchResponse;

public interface MessageSender {
    public void sendMessage(NearbySearchResponse nearbySearchResponse) ;
}
