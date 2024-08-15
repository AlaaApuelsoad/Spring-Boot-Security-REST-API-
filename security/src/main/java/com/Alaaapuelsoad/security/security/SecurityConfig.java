package com.Alaaapuelsoad.security.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Autowired
    private UserDetailsService userDetailsService;

    @Bean
    public PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                .csrf(csrf -> csrf.disable())
                .authorizeHttpRequests(auth -> auth
                        .requestMatchers(HttpMethod.GET,"/api/users/**").hasRole("admin")
                        .requestMatchers(HttpMethod.POST,"/api/users").hasRole("admin")
                        .requestMatchers(HttpMethod.DELETE,"/api/users/**").hasRole("admin")
                        .requestMatchers(HttpMethod.GET,"/api/roles/**").hasRole("admin")
                        .requestMatchers(HttpMethod.POST,"/api/roles/**").hasRole("admin")
                        .requestMatchers(HttpMethod.DELETE,"/api/roles/**").hasRole("admin")
                        .requestMatchers("/api/products/**").hasAnyRole("admin","customer")
                        .requestMatchers("/api/orders/**").hasAnyRole("admin","customer")
                        .anyRequest().authenticated()
                )
                .userDetailsService(userDetailsService)
                .httpBasic(Customizer.withDefaults());
        return http.build();
    }


    //Public access
//    @Bean
//    public SecurityFilterChain publicAccess(HttpSecurity http) throws Exception {
//        http
//                .csrf(csrf -> csrf.disable()) // Disable CSRF protection
//                .authorizeHttpRequests(auth -> auth
//                        .requestMatchers("/api/orders/**").permitAll()  // Public access to orders
//                        .requestMatchers("/api/products/**").permitAll() // Public access to products
//                        .anyRequest().permitAll() // Public access to all other endpoints
//                )
//                .httpBasic(Customizer.withDefaults()); // Optional: basic authentication for protected endpoints
//        return http.build();
//    }


//    @Bean
//    public UserDetailsService userDetailsService() {
//        UserDetails user = User.withUsername("alaa")
//                .password("{noop}alaa123")
//                .roles("USER")
//                .build();
//        UserDetails admin = User.withUsername("admin")
//                .password("{noop}admin123")
//                .roles("ADMIN")
//                .build();
//        return new InMemoryUserDetailsManager(user, admin);
//    }
}
