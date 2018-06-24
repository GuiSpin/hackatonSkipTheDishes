package com.vanhack.api.skip.hackatonskipthedishesmain;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@EnableEurekaClient
@SpringBootApplication(exclude = SecurityAutoConfiguration.class)
public class HackatonSkipTheDishesMainApplication {

    public static String EXCHANGE_NAME = "hackatonExchange";

    public static String QUEUE_NAME = "hackatonQueue";

    public static String ROUTING_KEY = "message.key";

    public static void main(String[] args) {
		SpringApplication.run(HackatonSkipTheDishesMainApplication.class, args);
	}

	@Bean
	public RestTemplate restTemplate() {
		return new RestTemplate();
	}

    @Bean
    public TopicExchange appExchange() {
        return new TopicExchange(EXCHANGE_NAME);
    }

    @Bean
    public Queue appQueue() {
        return new Queue(QUEUE_NAME);
    }

    @Bean
    public Binding declareBindingSpecific() {
        return BindingBuilder.bind(appQueue()).to(appExchange()).with(ROUTING_KEY);
    }
}
