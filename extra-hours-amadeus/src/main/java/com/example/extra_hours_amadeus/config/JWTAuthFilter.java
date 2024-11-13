package com.example.extra_hours_amadeus.config;

import com.example.extra_hours_amadeus.service.JWTTokenService;
import com.example.extra_hours_amadeus.service.JWTUtils;
import com.example.extra_hours_amadeus.service.OurUserDetailsService;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Component
public class JWTAuthFilter extends OncePerRequestFilter {

    @Autowired
    private JWTUtils jwtUtils;

    @Autowired
    private OurUserDetailsService ourUserDetailsService;

    @Autowired
    private JWTTokenService jwtTokenService;

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {

        final String authHeader = request.getHeader("Authorization");
        final String jwtToken;
        final String userEmail;

        if (authHeader == null || !authHeader.startsWith("Bearer ")) {
            filterChain.doFilter(request, response);
            return;
        }

        jwtToken = authHeader.substring(7);

        // Verificar si el token está invalidado
        if (jwtTokenService.isTokenInvalid(jwtToken)) {
            filterChain.doFilter(request, response);
            return;
        }

        userEmail = jwtUtils.extractUsername(jwtToken);

        List<GrantedAuthority> authorities = null;
        if (userEmail != null && SecurityContextHolder.getContext().getAuthentication() == null) {
            UserDetails userDetails = ourUserDetailsService.loadUserByUsername(userEmail);

            // Verificar si el token es válido y si coincide con los roles actuales del usuario en la base de datos
            if (jwtUtils.isTokenValid(jwtToken, userDetails)) {
                authorities = new ArrayList<>(userDetails.getAuthorities());

                UsernamePasswordAuthenticationToken authToken = new UsernamePasswordAuthenticationToken(
                        userDetails, null, authorities
                );
                authToken.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
                SecurityContextHolder.getContext().setAuthentication(authToken);
            } else if (jwtUtils.isTokenExpired(jwtToken)) {
                // Genera un nuevo token de acceso si el actual está expirado
                String newAccessToken = jwtUtils.generateToken(userDetails);
                response.setHeader("Authorization", "Bearer " + newAccessToken);
            }
        }
        filterChain.doFilter(request, response);

        System.out.println("Usuario autenticado: " + userEmail);
        System.out.println("Autoridades: " + authorities);
    }
    }

