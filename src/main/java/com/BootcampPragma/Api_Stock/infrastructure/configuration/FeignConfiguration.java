package com.BootcampPragma.Api_Stock.infrastructure.configuration;

import com.BootcampPragma.Api_Stock.infrastructure.Utils.InfraConstants;
import com.BootcampPragma.Api_Stock.infrastructure.Utils.UserExtractor;
import feign.RequestInterceptor;
import feign.RequestTemplate;
import lombok.AllArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@AllArgsConstructor
public class FeignConfiguration {
    private final UserExtractor userExtractor;
    @Bean
    public RequestInterceptor requestInterceptor() {
        return new RequestInterceptor() {
            @Override
            public void apply(RequestTemplate template) {
                String token = InfraConstants.BEARER + userExtractor.getTokenFromRequest();
                template.header(InfraConstants.AUTHORIZATION, token);
            }
        };
    }
}
