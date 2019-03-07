package br.com.ithiago.pet.gateway.configuration;

import br.com.ithiago.pet.gateway.configuration.fallback.GenericFallbackProvider;
import org.springframework.cloud.netflix.zuul.filters.route.FallbackProvider;
import org.springframework.cloud.netflix.zuul.filters.route.ZuulFallbackProvider;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.client.ClientHttpResponse;

/**
 * Created by thiago on 12/30/18.
 */

@Configuration
public class HystrixFallbackConfiguration {

    @Bean
    public FallbackProvider fallbackProviderRegisterService() {
        return new GenericFallbackProvider("register-service");
    }

    @Bean
    public FallbackProvider fallbackProviderScheduleService() {
        return new GenericFallbackProvider("schedule-service");
    }
}
