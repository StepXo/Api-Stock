package com.BootcampPragma.Api_Stock.infrastructure.securityconfig;

import com.BootcampPragma.Api_Stock.infrastructure.Utils.InfraConstants;
import com.BootcampPragma.Api_Stock.infrastructure.securityconfig.jwtconfiguration.JwtAuthenticationFilter;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
@EnableWebSecurity
@RequiredArgsConstructor
public class ConfigFilter {
    private final AuthenticationProvider authenticationProvider;
    private final JwtAuthenticationFilter jwtAuthFilter;

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {

        return http
                .csrf(AbstractHttpConfigurer::disable)
                .authorizeHttpRequests(auth -> auth
                        .requestMatchers(HttpMethod.POST, InfraConstants.BRAND).hasRole(InfraConstants.ROLE_ADMIN)
                        .requestMatchers(HttpMethod.GET, InfraConstants.getPath(InfraConstants.BRAND, InfraConstants.LIST)).authenticated()
                        .requestMatchers(HttpMethod.GET, InfraConstants.BRAND).authenticated()

                        .requestMatchers(HttpMethod.POST, InfraConstants.CATEGORY).hasRole(InfraConstants.ROLE_ADMIN)
                        .requestMatchers(HttpMethod.GET, InfraConstants.getPath(InfraConstants.CATEGORY, InfraConstants.LIST)).authenticated()
                        .requestMatchers(HttpMethod.GET, InfraConstants.CATEGORY).authenticated()

                        .requestMatchers(HttpMethod.POST, InfraConstants.ITEM).hasRole(InfraConstants.ROLE_ADMIN)
                        .requestMatchers(HttpMethod.POST, InfraConstants.getPath(InfraConstants.ITEM, InfraConstants.SUPPLY)).hasAnyRole(InfraConstants.ROLE_ADMIN, InfraConstants.ROLE_WAREHOUSE_AUX)
                        .requestMatchers(HttpMethod.GET, InfraConstants.getPath(InfraConstants.ITEM, InfraConstants.LIST)).authenticated()
                        .requestMatchers(HttpMethod.GET, InfraConstants.ITEM).authenticated()
                        .requestMatchers(HttpMethod.GET, InfraConstants.getPath(InfraConstants.ITEM, InfraConstants.TYPE_ORDER)).authenticated()
                        .requestMatchers(HttpMethod.GET, InfraConstants.getPath(InfraConstants.ITEM, InfraConstants.GET_ID)).hasAnyRole(InfraConstants.ROLE_USER, InfraConstants.ROLE_ADMIN)
                        .requestMatchers(HttpMethod.GET, InfraConstants.getPath(InfraConstants.ITEM, InfraConstants.CART)).authenticated()
                        .requestMatchers(HttpMethod.POST, InfraConstants.getPath(InfraConstants.ITEM, InfraConstants.BUY)).authenticated()

                        .anyRequest().authenticated())
                .sessionManagement(session -> session
                        .sessionCreationPolicy(SessionCreationPolicy.STATELESS))
                .authenticationProvider(authenticationProvider)
                .addFilterBefore(jwtAuthFilter, UsernamePasswordAuthenticationFilter.class)
                .build();
    }
}
