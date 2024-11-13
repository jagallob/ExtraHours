package com.example.extra_hours_amadeus.service;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;
import java.nio.charset.StandardCharsets;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Function;

@Component
public class JWTUtils {

    private final SecretKey key;
    private static final long ACCESS_TOKEN_EXPIRATION = 1814400000;  // 21 days
    private static final long REFRESH_TOKEN_EXPIRATION = 604800000;  // 7 days

    public JWTUtils() {
        String secretString = "843567893696976453275974432697R634976R738467TR678T34865R6834R8763T478378637664538745673865783678548735687R3";
        byte[] keyBytes = secretString.getBytes(StandardCharsets.UTF_8);
        this.key = new SecretKeySpec(keyBytes, "HmacSHA256");
    }

    public String generateToken(UserDetails userDetails) {
        HashMap<String, Object> claims = new HashMap<>();
        claims.put("roles", userDetails.getAuthorities().stream()
                .map(grantedAuthority -> grantedAuthority.getAuthority())
                .toList());

        return createToken(claims, userDetails.getUsername(), ACCESS_TOKEN_EXPIRATION);
    }

    public String generateRefreshToken(Map<String, Object> claims, UserDetails userDetails) {
        return Jwts.builder()
                .setClaims(claims)
                .setSubject(userDetails.getUsername())
                .setIssuedAt(new Date(System.currentTimeMillis()))
                .setExpiration(new Date(System.currentTimeMillis() + REFRESH_TOKEN_EXPIRATION))
                .signWith(key, SignatureAlgorithm.HS256)
                .compact();
    }

    private String createToken(HashMap<String, Object> claims, String subject, long expiration) {
        return Jwts.builder()
                .setClaims(claims)
                .setSubject(subject)
                .setIssuedAt(new Date(System.currentTimeMillis()))
                .setExpiration(new Date(System.currentTimeMillis() + expiration))
                .signWith(key, SignatureAlgorithm.HS256)
                .compact();
    }

    public String extractUsername(String token) {
        return extractClaims(token, Claims::getSubject);
    }

    // Método principal que extrae todos los claims
    public Claims extractClaims(String token) {
        return Jwts.parser()
                .setSigningKey(key)
                .build()
                .parseClaimsJws(token)
                .getBody();
    }

    // Método sobrecargado para resolver claims específicos
    private <T> T extractClaims(String token, Function<Claims, T> claimsResolver) {
        final Claims claims = extractClaims(token);  // Llama al método principal
        return claimsResolver.apply(claims);
    }

    public boolean isTokenValid(String token, UserDetails userDetails) {
        final String username = extractUsername(token);
        Claims claims = extractClaims(token);

        // Validate roles from the database
        List<String> tokenRoles = (List<String>) claims.get("roles");
        List<String> userRoles = userDetails.getAuthorities().stream()
                .map(grantedAuthority -> grantedAuthority.getAuthority())
                .toList();

        return (username.equals(userDetails.getUsername())
                && !isTokenExpired(token)
                && tokenRoles.containsAll(userRoles));
    }

    public boolean isTokenExpired(String token) {
        return extractClaims(token, Claims::getExpiration).before(new Date());
    }

//    public Claims extractClaims(String token) {
//        return Jwts.parser()
//                .setSigningKey(key)
//                .build()
//                .parseClaimsJws(token)
//                .getBody();
//    }
//
//    public String generateToken(UserDetails userDetails) {
//        return Jwts.builder()
//                .setSubject(userDetails.getUsername())
//                .setIssuedAt(new Date(System.currentTimeMillis()))
//                .setExpiration(new Date(System.currentTimeMillis() + EXPIRATION_TIME))
//                .signWith(key, SignatureAlgorithm.HS256)
//                .compact();
//    }
//
//    public String generateRefreshToken(HashMap<String, Object> claims, UserDetails userDetails) {
//        return Jwts.builder()
//                .setClaims(claims)
//                .setSubject(userDetails.getUsername())
//                .setIssuedAt(new Date(System.currentTimeMillis()))
//                .setExpiration(new Date(System.currentTimeMillis() + EXPIRATION_TIME))
//                .signWith(key, SignatureAlgorithm.HS256)
//                .compact();
//    }
//
//    public Claims extractClaims(String token) {
////        System.out.println("Token before parsing: " + token);
//        return Jwts.parser()
//                .setSigningKey(key)
//                .build()
//                .parseClaimsJws(token)
//                .getBody();
//    }
//
//    public String extractUsername(String token) {
//        return extractClaims(token, Claims::getSubject);
//    }
//
//    private <T> T extractClaims(String token, Function<Claims, T> claimsResolver) {
//        final Claims claims = extractClaims(token);
//        return claimsResolver.apply(claims);
//    }
//
//    public boolean isTokenValid(String token, UserDetails userDetails) {
//        final String username = extractUsername(token);
//        return (username.equals(userDetails.getUsername()) && !isTokenExpired(token));
//    }
//
//    public boolean isTokenExpired(String token) {
//        return extractClaims(token, Claims::getExpiration).before(new Date());
//    }
}
