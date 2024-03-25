package fr.idformation.pokedex.security.service;

import java.util.Optional;

import fr.idformation.pokedex.security.models.RefreshToken;

public interface IRefreshTokenService {

	/**
	 * Find a refresh token based on a given token.
	 *
	 * @param token the token
	 * @return the matching refresh token
	 */
	Optional<RefreshToken> findByToken(String token);

	/**
	 * Create a refresh token for a user.
	 *
	 * @param userId the id of the user
	 * @return the refresh token
	 */
	RefreshToken createRefreshToken(Long userId);

	/**
	 * Check if a refresh Token is not expired.
	 *
	 * @param token the token to be checked
	 * @return the token if not expired
	 */
	RefreshToken verifyExpiration(RefreshToken token);

	/**
	 * Delete the refershToken linked to a given user.
	 *
	 * @param userId the id of the user
	 * @return number of refreshToken deleted
	 */
	int deleteByUserId(Long userId);

	/**
	 * Delete tokens where expiration is over.
	 */
	void deleteExpired();
}
