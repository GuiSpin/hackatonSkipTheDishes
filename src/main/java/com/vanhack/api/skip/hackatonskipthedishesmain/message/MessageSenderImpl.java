package com.vanhack.api.skip.hackatonskipthedishesmain.message;

import com.vanhack.api.skip.hackatonskipthedishesmain.HackatonSkipTheDishesMainApplication;
import com.vanhack.api.skip.hackatonskipthedishesmain.domain.NearbySearchResponse;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MessageSenderImpl implements MessageSender {

    private final RabbitTemplate rabbitTemplate;

    @Autowired
    public MessageSenderImpl(final RabbitTemplate rabbitTemplate) {
        this.rabbitTemplate = rabbitTemplate;
    }

    public void sendMessage(NearbySearchResponse nearbySearchResponse) {

        rabbitTemplate.convertAndSend(
                HackatonSkipTheDishesMainApplication.EXCHANGE_NAME,
                HackatonSkipTheDishesMainApplication.ROUTING_KEY,
                nearbySearchResponse);
    }
}
