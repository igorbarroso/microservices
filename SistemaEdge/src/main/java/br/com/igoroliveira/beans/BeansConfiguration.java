package br.com.igoroliveira.beans;

import br.com.igoroliveira.utils.ScoreCalculator;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class BeansConfiguration {
    @Bean
    @LoadBalanced   // tells RestTemplate to look for a service in discovery server
    public RestTemplate getRestTemplate(){
        return new RestTemplate();
    }

    @Bean
    public ScoreCalculator getScoreCalculator(){return new ScoreCalculator();}
}
