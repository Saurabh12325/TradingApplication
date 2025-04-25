package com.Trading.Trading.Config;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.web.filter.OncePerRequestFilter;

import io.jsonwebtoken.security.Keys;

import javax.crypto.SecretKey;
import java.io.IOException;

public class JwtTokenValidator extends OncePerRequestFilter {

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        String jwtToken = request.getHeader(JwtConstant.JWT_HEADER);

        if(jwtToken != null) {
            jwtToken = jwtToken.substring(7);
            try{
               SecretKey key = Keys.hmacShaKeyFor(JwtConstant.SECRET_KEY.getBytes());

               Claims claims = Jwts.parser().setSigningKey(key).build().parseClaimsJws(jwtToken).getBody();
            } catch (Exception e) {
                throw new RuntimeException("Invalid JWT token");
            }
        }
    }
}
