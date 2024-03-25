package fr.idformation.pokedex.security.service.impl;

import java.time.Instant;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import fr.idformation.pokedex.security.jwt.exception.TokenRefreshException;
import fr.idformation.pokedex.security.models.RefreshToken;
import fr.idformation.pokedex.security.repository.RefreshTokenRepository;
import fr.idformation.pokedex.security.repository.UserRepository;
import fr.idformation.pokedex.security.service.IRefreshTokenService;
import jakarta.transaction.Transactional;

@Service
public class RefreshTokenServiceImpl implements IRefreshTokenService {
	/** Refresh Token duration. */
	@Value("${app.jwtExpirationInMs}")
	private Long refreshTokenDurationMs;

	/** the refresh token repository. */
	@Autowired
	private RefreshTokenRepository refreshTokenRepository;

	/** the repository. */
	@Autowired
	private UserRepository userRepository;

	/**
	 * .
	 */
	@Override
	@Transactional
	public void deleteExpired() {
		refreshTokenRepository.deleteByExpirityDateBefore(Instant.now());
	}

	/**
	 * .
	 */
	@Override
	public Optional<RefreshToken> findByToken(final String token) {
		return refreshTokenRepository.findByToken(token);
	}

	/**
	 * .
	 */
	@Override
	@Transactional
	public RefreshToken createRefreshToken(final Long userId) {

		RefreshToken refreshToken = new RefreshToken();

		refreshToken.setUser(userRepository.findById(userId).get());
		refreshToken.setExpirityDate(Instant.now().plusMillis(refreshTokenDurationMs));
		refreshToken.setToken(UUID.randomUUID().toString());

		refreshToken = refreshTokenRepository.save(refreshToken);
		return refreshToken;
	}

	/**
	 * .
	 */
	@Override
	@Transactional
	public RefreshToken verifyExpiration(final RefreshToken token) {
		if (token.getExpirityDate().isBefore(Instant.now())) {
			refreshTokenRepository.delete(token);
			throw new TokenRefreshException(token.getToken(),
					"Refresh token was expired. Please make a new signin request");
		}

		return token;
	}

	/**
	 * .
	 */
	@Override
	@Transactional
	public int deleteByUserId(final Long userId) {
		return refreshTokenRepository.deleteByUser(userRepository.findById(userId).get());
	}
}
