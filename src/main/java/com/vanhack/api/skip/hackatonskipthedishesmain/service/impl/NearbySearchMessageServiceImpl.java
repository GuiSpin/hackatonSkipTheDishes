package com.vanhack.api.skip.hackatonskipthedishesmain.service.impl;

import com.vanhack.api.skip.hackatonskipthedishesmain.domain.NearbySearchResponse;
import com.vanhack.api.skip.hackatonskipthedishesmain.message.MessageSender;
import com.vanhack.api.skip.hackatonskipthedishesmain.service.NearbySearchMessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class NearbySearchMessageServiceImpl implements NearbySearchMessageService {

    @Autowired
    MessageSender messageSender;

    @Override
    public void sendNearbySearchMessageRabbit(NearbySearchResponse nearbySearchResponse) {
        messageSender.sendMessage(nearbySearchResponse);
    }
}
