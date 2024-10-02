package com.amey.spring_security.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AuthorizeHttpRequestsConfigurer;
import org.springframework.security.config.annotation.web.configurers.CsrfConfigurer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    // FOR USER DEFINED SECURITY CONFIGS
    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {

        // WITHOUT LAMBDA
//        Customizer<CsrfConfigurer<HttpSecurity>> custCsrf = new Customizer<CsrfConfigurer<HttpSecurity>>() {
//            @Override
//            public void customize(CsrfConfigurer<HttpSecurity> httpSecurityCsrfConfigurer) {
//                httpSecurityCsrfConfigurer.disable();
//            }
//        };
//        http.csrf(custCsrf);

//        Customizer<AuthorizeHttpRequestsConfigurer<HttpSecurity>.AuthorizationManagerRequestMatcherRegistry> custHttp = new Customizer<AuthorizeHttpRequestsConfigurer<org.springframework.security.config.annotation.web.builders.HttpSecurity>.AuthorizationManagerRequestMatcherRegistry>() {
//            @Override
//            public void customize(AuthorizeHttpRequestsConfigurer<HttpSecurity>.AuthorizationManagerRequestMatcherRegistry authorizationManagerRequestMatcherRegistry) {
//                authorizationManagerRequestMatcherRegistry.anyRequest().authenticated();
//            }
//        };
       // http.authorizeHttpRequests(custHttp);

        // DISABLING METHOD
        // MAKING SESSION STATELESS
         http.csrf(customizer -> customizer.disable());
         http.authorizeHttpRequests(request -> request.anyRequest().authenticated());
         http.formLogin(Customizer.withDefaults());
         http.httpBasic(Customizer.withDefaults());
         http.sessionManagement(sesssion -> sesssion.sessionCreationPolicy(SessionCreationPolicy.STATELESS));

        return http.build();
    }
}
