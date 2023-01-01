package com.backend.securityservice.filter;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.backend.securityservice.model.MyUser;
import com.backend.securityservice.repository.UserRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.MediaType;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.AuthenticationManagerResolver;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.web.authentication.AuthenticationConverter;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.*;

@AllArgsConstructor
@Slf4j
public class AuthenticationFilter extends UsernamePasswordAuthenticationFilter {

    private AuthenticationManager authenticationManager;
    private UserRepository userRepository;


    @Override
    public Authentication attemptAuthentication(HttpServletRequest request, HttpServletResponse response) throws AuthenticationException {
//        String username, password;

        String username=request.getParameter("username");
        String password=request.getParameter("password");
        log.info(username+" "+password);

        UsernamePasswordAuthenticationToken authRequest = UsernamePasswordAuthenticationToken.unauthenticated(username, password);
        return authenticationManager.authenticate(authRequest);

//        try {
//            Map<String, String> requestMap = new ObjectMapper().readValue(request.getInputStream(), Map.class);
//            username = requestMap.get("username");
//            password = requestMap.get("password");
//        } catch (IOException e) {
//            throw new RuntimeException(e);
//        }

        //        return new UsernamePasswordAuthenticationToken(username, password);
    }

    @Override
    protected void successfulAuthentication(HttpServletRequest request, HttpServletResponse response, FilterChain chain, Authentication authResult) throws IOException, ServletException {
//        super.successfulAuthentication(request, response, chain, authResult);

//        log.info("here name "+authResult.getPrincipal().toString());
        log.info("here UsernamePasswordAuthenticationFilter");

        User user = (User) authResult.getPrincipal();
        Algorithm algorithm = Algorithm.HMAC256("secret".getBytes());
//        log.info("from auth " + user.getAuthorities().iterator().next());

        MyUser dbUser=userRepository.findFirstByEmail(user.getUsername());
        String accesToken = JWT.create().
                withClaim("role", String.valueOf(user.getAuthorities().iterator().next()))
                .withSubject(user.getUsername()).withExpiresAt(new Date(System.currentTimeMillis() + 60* 60 * 1000))
                .sign(algorithm);

        String refreshToken = JWT.create()
                .withSubject(user.getUsername()).withExpiresAt(new Date(System.currentTimeMillis() + 120* 60 * 1000))
                .withClaim("role", String.valueOf(user.getAuthorities().iterator().next()))
                .sign(algorithm);
        Map<String, String> tokens = new HashMap<>();

        tokens.put("accessToken", accesToken);
        tokens.put("refreshToken", refreshToken);
        tokens.put("role", String.valueOf(user.getAuthorities().iterator().next()));
        tokens.put("email", user.getUsername());
        tokens.put("userId", String.valueOf(dbUser.getId()));
        tokens.put("fullName", dbUser.getFirst_name()+" "+dbUser.getLast_name());

        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS Z");
        String expDate=format.format(new Date(System.currentTimeMillis() + 60* 60 * 1000));
        log.info(expDate);
        tokens.put("exp", expDate);

        response.setContentType(MediaType.APPLICATION_JSON_VALUE);

        new ObjectMapper().writeValue(response.getOutputStream(), tokens);


//        Map<String, String> map = new HashMap<>();
//
//        map.put("name", user.getUsername());
//        map.put("role", String.valueOf(user.getAuthorities().iterator().next()));
//
//        response.setContentType(MediaType.APPLICATION_JSON_VALUE);
//        new ObjectMapper().writeValue(response.getOutputStream(),"goodd");
//
//        response.setHeader("test","test");
//        new ObjectMapper().writeValue(response.getOutputStream(), map);
    }

    @Override
    protected void unsuccessfulAuthentication(HttpServletRequest request, HttpServletResponse response, AuthenticationException failed) throws IOException, ServletException {
//        super.unsuccessfulAuthentication(request, response, failed);
        response.setContentType(MediaType.APPLICATION_JSON_VALUE);
        new ObjectMapper().writeValue(response.getOutputStream(),null);

        log.error( "username ou password est incorrect");

    }
}
