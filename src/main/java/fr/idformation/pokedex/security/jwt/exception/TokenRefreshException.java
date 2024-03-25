package fr.idformation.pokedex.security.jwt.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.FORBIDDEN)
public class TokenRefreshException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	/**
	 * Build a new Exception.
	 *
	 * @param token   the token
	 * @param message the message
	 */
	public TokenRefreshException(final String token, final String message) {
		super(String.format("Failed for [%s]: %s", token, message));
	}
}
