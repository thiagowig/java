package br.com.ithiago.pet.gateway.configuration.fallback;

import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.netflix.zuul.filters.route.FallbackProvider;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.client.ClientHttpResponse;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;

/**
 * Created by thiago on 12/30/18.
 */

@Slf4j
public class GenericFallbackProvider implements FallbackProvider {

    private String responseBody = "{\"message\":\"Service Unavailable. Please try after sometime\"}";

    private HttpStatus statusCode = HttpStatus.SERVICE_UNAVAILABLE;

    private String statusText = "Service Unavailable";

    private String route;

    public GenericFallbackProvider(String route) {
        this.route = route;
    }

    @Override
    public ClientHttpResponse fallbackResponse(Throwable throwable) {
        log.error("Error on service " + getRoute(), throwable);
        return fallbackResponse();
    }

    @Override
    public String getRoute() {
        return this.route;
    }

    @Override
    public ClientHttpResponse fallbackResponse() {
        return new ClientHttpResponse() {
            @Override
            public HttpStatus getStatusCode() throws IOException {
                return statusCode;
            }

            @Override
            public int getRawStatusCode() throws IOException {
                return statusCode.value();
            }

            @Override
            public String getStatusText() throws IOException {
                return statusText;
            }

            @Override
            public void close() {
                // Do nothing
            }

            @Override
            public InputStream getBody() throws IOException {
                return new ByteArrayInputStream(responseBody.getBytes());
            }

            @Override
            public HttpHeaders getHeaders() {
                return new HttpHeaders();
            }
        };
    }
}
