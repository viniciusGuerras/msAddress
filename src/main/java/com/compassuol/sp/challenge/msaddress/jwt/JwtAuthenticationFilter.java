package com.compassuol.sp.challenge.msaddress.jwt;

import com.compassuol.sp.challenge.msaddress.jwt.service.JwtService;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.preauth.PreAuthenticatedAuthenticationToken;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;

@Component
@RequiredArgsConstructor
@Slf4j
public class JwtAuthenticationFilter extends OncePerRequestFilter{

    private final JwtService service;

    public static final String JWT_BEARER = "Bearer ";

    public static final String JWT_AUTHORIZATION = "Authorization";


    @Override
    protected void doFilterInternal(@NonNull HttpServletRequest request,
                                    @NonNull HttpServletResponse response,
                                    @NonNull FilterChain filterChain) throws ServletException, IOException {


        final String authHeader = request.getHeader(JWT_AUTHORIZATION);

        if (!authHeader.startsWith(JWT_BEARER)) {
            filterChain.doFilter(request, response);
            return;
        }

        String token = authHeader.substring(JWT_BEARER.length());
        String email = service.extractEmail(token);

        if (email != null && SecurityContextHolder.getContext().getAuthentication() == null) {
            if (service.validateToken(token)) {
                PreAuthenticatedAuthenticationToken authToken = new PreAuthenticatedAuthenticationToken(token, null, null);
                SecurityContextHolder.getContext().setAuthentication(authToken);
            }
        }
        filterChain.doFilter(request, response);
    }
}
