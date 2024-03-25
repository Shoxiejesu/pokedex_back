package fr.idformation.pokedex.security.repository;

import java.time.Instant;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import fr.idformation.pokedex.security.models.RefreshToken;
import fr.idformation.pokedex.security.models.User;

@Repository
public interface RefreshTokenRepository extends JpaRepository<RefreshToken, Long> {

	/**
	 * Find a Refresh token by a token.
	 *
	 * @param token a token
	 * @return a refreshToken
	 */
	Optional<RefreshToken> findByToken(String token);

	/**
	 * Delete the refershToken linked to a given user.
	 *
	 * @param user a user
	 * @return number of token deleted
	 */
	int deleteByUser(User user);

	/**
	 * Delete tokens expired before a given time.
	 *
	 * @param instant the threshold instant
	 * @return number of token deleted
	 */
	int deleteByExpirityDateBefore(Instant instant);
}
