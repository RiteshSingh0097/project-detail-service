package com.shobhit.project.detail.service.filter;

import com.shobhit.project.detail.service.exception.UnauthorisedException;
import io.jsonwebtoken.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;
import java.util.Objects;

import static com.shobhit.project.detail.service.constant.SecurityConstants.AUTHORIZATION_HEADER;
import static com.shobhit.project.detail.service.constant.SecurityConstants.BEARER_PREFIX;

/**
 * @author smriti on 6/27/19
 */

@Component
public class JwtTokenProvider {

    private static final Logger LOGGER = LoggerFactory.getLogger(JwtTokenProvider.class);


    private final UserDetailsService userDetailsService;

    @Value("${jwt.secret}")
    private String secretKey;

    public JwtTokenProvider(UserDetailsService userDetailsService) {
        this.userDetailsService = userDetailsService;
    }

    public String createToken(String username) {
        return Jwts.builder()
                .setSubject(username)
                .setIssuer(secretKey)
                .setExpiration(calculateExpirationDate())
                .signWith(SignatureAlgorithm.HS256, secretKey)
                .compact();
    }

    private Date calculateExpirationDate() {
        Date now = new Date();
        return new Date(now.getTime() + 10*60*1000);
    }

    public Authentication getAuthentication(String token) {
        UserDetails userDetails = this.userDetailsService.loadUserByUsername(getUsername(token));
        return new UsernamePasswordAuthenticationToken(userDetails, "", userDetails.getAuthorities());
    }

    private String getUsername(String token) {
        return Jwts.parser().setSigningKey(secretKey).parseClaimsJws(token).getBody().getSubject();
    }

    public String resolveToken(HttpServletRequest req) {
        String bearerToken = req.getHeader(AUTHORIZATION_HEADER);

        return (!Objects.isNull(bearerToken) && bearerToken.startsWith(BEARER_PREFIX)) ?
                bearerToken.substring(7) : null;
    }

    public boolean validateToken(String token) {

        try {
            Jws<Claims> claims = Jwts.parser()
                    .setSigningKey(secretKey)
                    .parseClaimsJws(token);

            return (!claims.getBody().getExpiration().before(new Date()));
        } catch (JwtException | IllegalArgumentException e) {
            LOGGER.error("Expired or invalid JWT token");
            throw new UnauthorisedException("rr");
        }
    }
}
