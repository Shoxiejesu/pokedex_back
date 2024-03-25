package fr.idformation.pokedex.security.jwt;

import java.security.Key;
import java.util.Base64;
import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.MalformedJwtException;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.UnsupportedJwtException;
import io.jsonwebtoken.security.Keys;

@Component
public class JwtProvider {
	/** a secret key provided in the app parameters. */
	@Value("${app.jwtSecretKey}")
	private String secret;

	/** the live time of the JWT provided in the app parameters. */
	@Value("${app.jwtExpirationInMs}")
	private int jwtExpirationInMs;

	/** a key. */
	private Key key;

	/** a logger for the class. */
	private final Logger logger = LoggerFactory.getLogger(getClass());

	/**
	 * Generate a JWT token.
	 *
	 * @param username the user
	 * @return the JWT token as a String
	 */
	public String generateToken(final String username) {
		Date now = new Date();
		Date expiryDate = new Date(now.getTime() + jwtExpirationInMs);

		return Jwts.builder().setSubject(username).setIssuedAt(new Date()).setExpiration(expiryDate)
				.signWith(getSigningKey(), SignatureAlgorithm.HS512).compact();
	}

	/**
	 * @param token the token to parse
	 * @return the date of expiration extracted from the JWT
	 */
	public Date getExpiryDate(final String token) {
		Claims claims = Jwts.parserBuilder().setSigningKey(getSigningKey()).build().parseClaimsJws(token).getBody();
		return claims.getExpiration();
	}

	private Key getSigningKey() {
		if (key == null) {
			byte[] keyBytes = Base64.getUrlDecoder().decode(this.secret);
			key = Keys.hmacShaKeyFor(keyBytes);
		}
		return key;
	}

	/**
	 * @param token the token to parse
	 * @return the login of the user
	 */
	public String getUserUsernameFromJWT(final String token) {
		Claims claims = Jwts.parserBuilder().setSigningKey(getSigningKey()).build().parseClaimsJws(token).getBody();
		return claims.getSubject();
	}

	/**
	 * Checks if the token is OK.
	 *
	 * @param authToken the token to parse
	 * @return true or false
	 */
	public boolean validateToken(final String authToken) {
		try {
			Jwts.parserBuilder().setSigningKey(getSigningKey()).build().parseClaimsJws(authToken);
			return true;
		} catch (io.jsonwebtoken.security.SecurityException e) {
			logger.error("Invalid JWT signature: {}", e.getMessage());
		} catch (MalformedJwtException e) {
			logger.error("Invalid JWT token: {}", e.getMessage());
		} catch (ExpiredJwtException e) {
			logger.error("JWT token is expired: {}", e.getMessage());
		} catch (UnsupportedJwtException e) {
			logger.error("JWT token is unsupported: {}", e.getMessage());
		} catch (IllegalArgumentException e) {
			logger.error("JWT claims string is empty: {}", e.getMessage());
		}
		return false;
	}
}
