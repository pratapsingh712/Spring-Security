package com.raghav.spring_security_demo.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                .csrf(csrf -> csrf.disable())
                .authorizeHttpRequests(auth -> auth
                        .requestMatchers("/login", "/register").permitAll()
                        .anyRequest().authenticated()
                );

        return http.build();
    }

    @Bean
    public AuthenticationManager authenticationManager(
            AuthenticationConfiguration configuration) throws Exception {
        return configuration.getAuthenticationManager();
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder(12);
    }
}




//    @Bean
//    public AuthenticationProvider authenticationProvider(UserDetailsService userDetailsService) {
//        return new DaoAuthenticationProvider(
//                userDetailsService
//        );
//    }


//    @Bean
//    public SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity){
//
////        Customizer<CsrfConfigurer<HttpSecurity>> custCsrf = new Customizer<CsrfConfigurer<HttpSecurity>>() {
////            @Override
////            public void customize(CsrfConfigurer<HttpSecurity> configurer) {
////                      configurer.disable();
////            }
////        };
////
////        httpSecurity.csrf(custCsrf);
////
////        Customizer<AuthorizeHttpRequestsConfigurer<HttpSecurity>.AuthorizationManagerRequestMatcherRegistry> custHttp = new Customizer<AuthorizeHttpRequestsConfigurer<org.springframework.security.config.annotation.web.builders.HttpSecurity>.AuthorizationManagerRequestMatcherRegistry>() {
////            @Override
////            public void customize(AuthorizeHttpRequestsConfigurer<HttpSecurity>.AuthorizationManagerRequestMatcherRegistry authorizationManagerRequestMatcherRegistry) {
////                authorizationManagerRequestMatcherRegistry.anyRequest().authenticated();
////            }
////        };
////
////        httpSecurity.authorizeHttpRequests(custHttp);
//
////        httpSecurity.csrf(customizer -> customizer.disable());
////        httpSecurity.authorizeHttpRequests(request -> request.anyRequest().authenticated());
////        httpSecurity.formLogin(Customizer.withDefaults());
////        httpSecurity.httpBasic(Customizer.withDefaults());
////        httpSecurity.sessionManagement(session -> session.sessionCreationPolicy(SessionCreationPolicy.STATELESS));
//
////        httpSecurity.csrf(customizer -> customizer.disable())
////                .authorizeHttpRequests(request -> request.anyRequest().authenticated())
////                .httpBasic(Customizer.withDefaults())
////                .sessionManagement(session -> session.sessionCreationPolicy(SessionCreationPolicy.STATELESS));
////
////        return httpSecurity.build();
////    }

//    @Bean
//    public UserDetailsService userDetailsService(){
//
//        UserDetails user = User.withDefaultPasswordEncoder()
//                .username("Raghav")
//                .password("1234")
//                .roles("USER")
//                .build();
//
//        return new InMemoryUserDetailsManager(user);
//    }
