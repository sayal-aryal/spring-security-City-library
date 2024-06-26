package edu.miu.cs.cs499.lesson9.citylibrarywebapisec.config;

import edu.miu.cs.cs499.lesson9.citylibrarywebapisec.filter.JWTAuthFilter;
import edu.miu.cs.cs499.lesson9.citylibrarywebapisec.service.impl.CityLibraryUserDetailsService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
@EnableWebSecurity
public class CityLibraryWebAPISecurityConfig {

    private CityLibraryUserDetailsService cityLibraryUserDetailsService;
    private JWTAuthFilter jwtAuthFilter;

    public CityLibraryWebAPISecurityConfig(CityLibraryUserDetailsService cityLibraryUserDetailsService, JWTAuthFilter jwtAuthFilter) {
        this.cityLibraryUserDetailsService = cityLibraryUserDetailsService;
        this.jwtAuthFilter = jwtAuthFilter;
    }

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity) throws Exception {
        return httpSecurity
                .csrf(AbstractHttpConfigurer::disable)
                .authorizeHttpRequests(
                        auth -> {
                            auth
                                    .requestMatchers("/citylibrary/public/hello").permitAll()
                                    .requestMatchers("/citylibrary/api/v1/public/auth/**").permitAll()
                                    .requestMatchers("/citylibrary/api/v1/publisher/**").authenticated();
//                                    .requestMatchers("/citylibrary/api/v1/publisher/get/**").authenticated();
                        }
                )
                .sessionManagement(session -> session.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
                .authenticationProvider(authenticationProvider())
                .addFilterBefore(jwtAuthFilter, UsernamePasswordAuthenticationFilter.class)
                .build();
    }

    @Bean
    public AuthenticationProvider authenticationProvider() {
        DaoAuthenticationProvider authenticationProvider = new DaoAuthenticationProvider();
        authenticationProvider.setUserDetailsService(cityLibraryUserDetailsService);
        authenticationProvider.setPasswordEncoder(passwordEncoder());
        return authenticationProvider;
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public AuthenticationManager authenticationManager(AuthenticationConfiguration config) throws Exception {
        return config.getAuthenticationManager();
    }
}
