package pe.edu.upc.fitfat.securities;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import javax.crypto.spec.SecretKeySpec;
import java.io.Serializable;
import java.util.Base64;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

@Component
public class JwtTokenUtil implements Serializable {

    private static final long serialVersionUID = -2550185165626007488L;
    public static final long JWT_TOKEN_VALIDITY = 5 * 60 * 60 * 1000;

    @Value("b469054535522cf03795fc8e994d67e99f91b18b606a8a2d89e477aa141c598063f0c034201790845c3cc53d6cdcd1393e09d260b6ec38cc73570113b4bc5729b151af5b056175e175f91676a024196c1ac36f58578c11fef294e14e0c9b02b6553f5a420d8d729155b46f6a97d4451307666d478365c3f959b29d0bc20d653f839943309bd2374a016bc284cabf7474f97f028be134deb8bb702c404e345b9ce24040b817cfaa564b80b41fc097ee78b0ca6e6fbd271cd9e55bbf3f8fa90679f0c8f204dd6fe702262ad5afa3e2f926d2c4fd839dae64f2b4438c71408c391822d0e7eb91748f12858a4c4a79df53e49e8f569caa77cc740688b0055cc46bb8")
    private String secret;

    public String getUsernameFromToken(String token) {
        return getClaimFromToken(token, Claims::getSubject);
    }

    public Date getExpirationDateFromToken(String token) {
        return getClaimFromToken(token, Claims::getExpiration);
    }

    public <T> T getClaimFromToken(String token, Function<Claims, T> claimsResolver) {
        final Claims claims = getAllClaimsFromToken(token);
        return claimsResolver.apply(claims);
    }

    private Claims getAllClaimsFromToken(String token) {
        return Jwts.parser().setSigningKey(secret).build().parseClaimsJws(token).getBody();
    }

    private Boolean isTokenExpired(String token) {
        final Date expiration = getExpirationDateFromToken(token);
        return expiration.before(new Date());
    }

    public String generateToken(UserDetails userDetails) {
        Map<String, Object> claims = new HashMap<>();
        claims.put("nombre", "daiki");
        claims.put("role", userDetails.getAuthorities().stream().map(r -> r.getAuthority()).collect(Collectors.joining()));
        return doGenerateToken(claims, userDetails.getUsername());
    }

    private String doGenerateToken(Map<String, Object> claims, String subject) {
        return Jwts.builder().setClaims(claims).setSubject(subject).setIssuedAt(new Date(System.currentTimeMillis()))
                .setExpiration(new Date(System.currentTimeMillis() + JWT_TOKEN_VALIDITY))
                .signWith(new SecretKeySpec(Base64.getDecoder().decode(secret), SignatureAlgorithm.HS512.getJcaName())).compact();
    }

    public Boolean validateToken(String token, UserDetails userDetails) {
        final String username = getUsernameFromToken(token);
        return (username.equals(userDetails.getUsername()) && !isTokenExpired(token));
    }
}
