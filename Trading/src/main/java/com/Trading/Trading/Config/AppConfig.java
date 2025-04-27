package com.Trading.Trading.Config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.www.BasicAuthenticationFilter;
import org.springframework.web.cors.CorsConfigurationSource;

@Configuration
public class AppConfig {

   @Bean
  public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http.sessionManagement((management->management.sessionCreationPolicy(SessionCreationPolicy.STATELESS)))
        .authorizeHttpRequests(authorizeRequests -> authorizeRequests.requestMatchers("/api/**").authenticated()
                .anyRequest().permitAll())
               .addFilterBefore(new JwtTokenValidator(), BasicAuthenticationFilter.class)
                .csrf(csrf->csrf.disable())
                .cors(cors->cors.configurationSource(corsConfiguration()));

        return http.build();
    }

    private CorsConfigurationSource corsConfiguration() {
        return null;
    }
}
