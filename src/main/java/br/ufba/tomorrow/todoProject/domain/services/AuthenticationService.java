package br.ufba.tomorrow.todoProject.domain.services;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.MalformedJwtException;
import io.jsonwebtoken.security.Keys;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;

import javax.crypto.SecretKey;
import java.util.Collections;
import java.util.Date;

public class AuthenticationService {
    static final long EXPIRATION_TIME = 60 * 15 * 1000;
    static final String SIGNING_KEY = "O segredo precisa ser longo para não dar pau";
    static final String PREFIX = "Bearer";
    private static final SecretKey SECRETKEY = Keys.hmacShaKeyFor(SIGNING_KEY.getBytes());

    static public void addToken(HttpServletResponse res, String email) {
        Date now = new Date();
        Date expirationDate = new Date(now.getTime() + EXPIRATION_TIME);
        String JwToken = Jwts.builder()
                .claim("sub", email)
                .claim("iat", now.getTime())
                .claim("exp", expirationDate.getTime())
                .signWith(SECRETKEY)
                .compact();
        res.addHeader("Authorization" ,PREFIX + " " + JwToken);
        res.addHeader("Acess-Control-Expose-Headers","Authorization" );

    }

    static public Authentication getAuthentication(HttpServletRequest request) {
        String token = request.getHeader("Authorization");
        if (token != null) {
            if (token.startsWith(PREFIX))
                token = token.substring(PREFIX.length()).trim();
            else
                throw new MalformedJwtException("Invalid Authorization header format");

            Claims claims = Jwts.parser()
                    .verifyWith(SECRETKEY)
                    .build()
                    .parseSignedClaims(token)
                    .getPayload();

            String email = claims.get("sub", String.class);
            if (email != null) {
                return new UsernamePasswordAuthenticationToken(email, null, Collections.emptyList());
            }
        }
        return null;
    }


}
