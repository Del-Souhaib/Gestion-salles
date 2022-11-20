package com.backend.securityservice.filter;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.DecodedJWT;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.MediaType;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Service;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.*;

import static org.springframework.http.HttpHeaders.AUTHORIZATION;

@Slf4j
public class AuthorizationFilter extends OncePerRequestFilter {

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        String header = request.getHeader(AUTHORIZATION);
        if (header == null) {
            filterChain.doFilter(request, response);
        } else {
            try {
                UsernamePasswordAuthenticationToken authentication = getAuthentication(request);

                SecurityContextHolder.getContext().setAuthentication(authentication);
                filterChain.doFilter(request, response);
            } catch (Exception exception) {
                response.setContentType(MediaType.APPLICATION_JSON_VALUE);

                new ObjectMapper().writeValue(response.getOutputStream(), exception.getMessage());

                logger.error(exception.getMessage());
            }
        }
    }

    private UsernamePasswordAuthenticationToken getAuthentication(HttpServletRequest request) {
        String token = request.getHeader(AUTHORIZATION);

        if (token != null) {
            // parse the token.
            Algorithm algorithm = Algorithm.HMAC256("secret".getBytes());

//            String jwt = JWT.require(algorithm)
//                    .build()
//                    .verify(token.replace("MyToken", ""))
//                    .getSubject();
            DecodedJWT jwt = JWT.require(algorithm)
                    .build()
                    .verify(token.replace("MyToken", ""));
            Collection<SimpleGrantedAuthority> authorities = new ArrayList<>();
            authorities.add(new SimpleGrantedAuthority(jwt.getClaim("role").asString()));
            log.info("role : "+jwt);


            if (jwt.getSubject() != null) {
                // new arraylist means authorities
                return new UsernamePasswordAuthenticationToken(jwt.getSubject(), null, authorities);
            }

            return null;
        }

        return null;
    }
}
