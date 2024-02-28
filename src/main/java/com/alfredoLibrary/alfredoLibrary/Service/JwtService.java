package com.alfredoLibrary.alfredoLibrary.Service;

import ch.qos.logback.core.subst.Token;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;
import org.apache.catalina.User;
import org.springframework.stereotype.Component;

import java.security.Key;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

@Component
public class JwtService {

    public static final String SECRET = "468792F427F4428472B4B6250655368566D5971Q37433O7397A2443264629";
    public String extractUsername(String token){
        return extractClaim(token, Claims::getSubject);

    }

    public Date extractExpiration(String token){
        return extractClaim(token, Claims::getExpiration);
    }


    private <T> T extractClaim(String token, Function<Claims, T> claimReslover) {

        final Claims claims = extractAllClaims(token);
        return claimReslover.apply(claims);


    }

    private Claims extractAllClaims(String token) {
        return Jwts
                .parserBuilder()
                .setSigningKey(getSignKey())
                .build()
                .parseClaimsJws(token)
                .getBody();
    }



    private Key getSignKey() {

        byte[] keyBytes =  Decoders.BASE64.decode(SECRET);
        return Keys.hmacShaKeyFor(keyBytes);
    }

    private Boolean isTokenKeyExpired(String token){
        return extractExpiration(token).before(new Date());
    }
    public String generateToken(String username){
        Map<String, Object> claims = new HashMap<>();
        return createToken(claims, username);
        
    }

    private String createToken(Map<String, Object> claims, String username) {
        return Jwts
                .builder()
                .setClaims(claims)
                .setSubject(username)
                .setIssuedAt(new Date(System.currentTimeMillis()))
                .setExpiration(new Date(System.currentTimeMillis()+1000*60+1))
                .signWith(getSignKey(), SignatureAlgorithm.HS256).compact();
    }
    public boolean validateToken(String token, User user){
        final String username = extractUsername(token);
        return username.equals(user.getUsername()) && !isTokenKeyExpired(token);
    }
}
