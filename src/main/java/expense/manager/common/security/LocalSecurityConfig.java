package expense.manager.common.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.oauth2.jwt.Jwt;
import org.springframework.security.oauth2.jwt.JwtDecoder;
import org.springframework.security.oauth2.jwt.JwtException;
import org.springframework.security.web.SecurityFilterChain;

import java.util.Map;
import java.util.function.Consumer;

@Configuration
@EnableWebSecurity
@Profile("local")
public class LocalSecurityConfig {


    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http.authorizeHttpRequests(auth -> auth
                        .requestMatchers("/admin/**").hasRole("ADMIN")
                        .requestMatchers("/openapi/**", "/swagger-ui/**").permitAll()
                        .anyRequest().authenticated()
                )
                .oauth2ResourceServer(oauth2 -> {
                    oauth2.jwt(jwtConfig -> {
                        jwtConfig.jwtAuthenticationConverter(SecurityUtil.grantedAuthoritiesExtractor());
                    });
                })
                .formLogin(AbstractHttpConfigurer::disable)
                .httpBasic(AbstractHttpConfigurer::disable);
        return http.build();
    }

    @Bean
    public JwtDecoder jwtDecoder() {

        return token -> {
            // Create a dummy JWT with minimal claims for local testing
            Consumer<Map<String, Object>> mapConsumer = claims -> {
                claims.put("sub", "abcd");
                claims.put("preferred_username", "shekhar");
                claims.put("scope", "read write");
            };

            if (!"dummy-token".equals(token))
                throw new JwtException("Invalid token");

            return Jwt.withTokenValue(token)
                    .header("alg", "none")
                    .claims(mapConsumer)
                    .build();
        };
    }

}
