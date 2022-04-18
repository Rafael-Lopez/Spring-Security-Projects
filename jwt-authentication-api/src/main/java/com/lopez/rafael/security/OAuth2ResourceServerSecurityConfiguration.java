package com.lopez.rafael.security;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.oauth2.jwt.JwtDecoder;
import org.springframework.security.oauth2.jwt.NimbusJwtDecoder;
import org.springframework.security.web.SecurityFilterChain;

import java.security.KeyFactory;
import java.security.NoSuchAlgorithmException;
import java.security.interfaces.RSAPublicKey;
import java.security.spec.EncodedKeySpec;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.X509EncodedKeySpec;
import java.util.Base64;

@EnableWebSecurity
public class OAuth2ResourceServerSecurityConfiguration {
    @Value("${spring.security.oauth2.resourceserver.jwt.key-value}")
    String publicKey;

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
            .httpBasic().disable()
            .csrf().disable()
            .sessionManagement()
                // If you always want to authenticate in each call use STATELESS. Otherwise, the
                // other policies will allow you to use the JSESSIONID cookie to not have to
                // authenticate every time after you already have done so.
                // https://www.baeldung.com/spring-security-session#security-config
            .sessionCreationPolicy(SessionCreationPolicy.STATELESS)
            .and()
            .authorizeHttpRequests((authorize) -> authorize.anyRequest().authenticated())
            .oauth2ResourceServer()
            .authenticationEntryPoint(new CustomOAuth2AuthenticationEntryPoint())
            .jwt(jwtConfigurer -> jwtDecoder());

        return http.build();
    }

    @Bean
    public JwtDecoder jwtDecoder() {
        KeyFactory kf = null;
        try {
            kf = KeyFactory.getInstance("RSA");
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        publicKey = publicKey.replace("-----BEGIN PUBLIC KEY-----", "")
                .replace("-----END PUBLIC KEY-----", "")
                .replace(" ", "");

        byte[] decoded = Base64.getDecoder().decode(publicKey);
        EncodedKeySpec keySpec = new X509EncodedKeySpec(decoded);
        RSAPublicKey publicKey = null;
        try {
            publicKey = (RSAPublicKey) kf.generatePublic(keySpec);
        } catch (InvalidKeySpecException e) {
            e.printStackTrace();
        }

        return NimbusJwtDecoder.withPublicKey(publicKey).build();
    }
}