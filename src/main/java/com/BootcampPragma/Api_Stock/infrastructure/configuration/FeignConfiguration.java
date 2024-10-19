package com.BootcampPragma.Api_Stock.infrastructure.configuration;

import com.BootcampPragma.Api_Stock.infrastructure.Utils.InfraConstants;
import com.BootcampPragma.Api_Stock.infrastructure.Utils.UserExtractor;
import feign.RequestInterceptor;
import feign.RequestTemplate;
import feign.codec.ErrorDecoder;
import lombok.AllArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

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
    @Bean
    public WebMvcConfigurer corsConfigurer() {
        return new WebMvcConfigurer() {
            @Override
            public void addCorsMappings(CorsRegistry registry) {
                registry.addMapping("/**").allowedOrigins("http://localhost:4200");
            }
        };
    }

}
