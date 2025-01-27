package com.demo.api_gateway.filter;

// import org.springframework.context.annotation.Bean;
// import org.springframework.context.annotation.Configuration;
// import org.springframework.web.cors.CorsConfiguration;
// import org.springframework.web.cors.reactive.CorsWebFilter;
// import org.springframework.web.cors.reactive.UrlBasedCorsConfigurationSource;

// @Configuration
// public class CorsGlobalConfiguration {

//     @Bean
//     public CorsWebFilter corsFilter() {
//         CorsConfiguration corsConfig = new CorsConfiguration();
//         corsConfig.setAllowCredentials(true);
//         corsConfig.addAllowedOrigin("http://localhost:5173"); // Allow all origins
//         corsConfig.addAllowedHeader("*"); // Allow all headers
//         corsConfig.addAllowedMethod("*"); // Allow all methods

//         UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
//         source.registerCorsConfiguration("/**", corsConfig); // Apply to all paths

//         return new CorsWebFilter(source);
//     }
// }

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.reactive.UrlBasedCorsConfigurationSource;
import org.springframework.web.cors.reactive.CorsWebFilter;

@Configuration
public class CorsGlobalConfiguration {

    @Bean
    public CorsWebFilter corsWebFilter() {
        CorsConfiguration config = new CorsConfiguration();

        // Specify allowed origins
        config.addAllowedOrigin("http://localhost:5173"); // Replace with your frontend URL
        // config.addAllowedOrigin("https://your-production-domain.com"); // Add
        // production URL

        // Specify allowed methods
        config.addAllowedMethod("GET");
        config.addAllowedMethod("POST");
        config.addAllowedMethod("PUT");
        config.addAllowedMethod("DELETE");
        config.addAllowedMethod("OPTIONS");

        // Specify allowed headers
        config.addAllowedHeader("*"); // Allow all headers

        // Allow credentials (e.g., cookies, Authorization headers)
        config.setAllowCredentials(true);

        // Apply the CORS configuration to all routes
        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        source.registerCorsConfiguration("/**", config);

        return new CorsWebFilter(source);
    }
}