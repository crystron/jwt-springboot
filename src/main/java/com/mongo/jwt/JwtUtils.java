package com.mongo.jwt;

import com.mongo.service.UserDetailsImpl;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.Authentication;

import java.util.Date;

public class JwtUtils {
    private static final Logger logger = LoggerFactory.getLogger(JwtUtils.class);
    @Value("${mongo.app.jwtSecret}")
    private String jwtSecret;

    @Value("${mongo.app.jwtExpirationMs}")
    private int jwtExpirationMS;

    public String generateJwtToken(Authentication authentication){
        UserDetailsImpl userPrincipals = (UserDetailsImpl) authentication.getPrincipal();

        return Jwts.builder()
                .setSubject(userPrincipals.getUsername())
                .setIssuedAt(new Date())
                .setExpiration(new Date(new Date().getTime() + jwtExpirationMS))
                .signWith(SignatureAlgorithm.ES512, jwtSecret)
                .compact();
    }

}
