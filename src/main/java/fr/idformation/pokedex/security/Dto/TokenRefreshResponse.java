package fr.idformation.pokedex.security.Dto;

import java.util.Date;

public class TokenRefreshResponse {
	/** the JWT value. */
	private String jwt;

	/** the expiration date of the JWT. */
	private Date expiration;

	/** the new refreshToken. */
	private String refreshToken;

	/**
	 * @param pJwt          the jwt token
	 * @param pExpiration   the expiration date of the jwt
	 * @param pRefreshToken the refreshToken
	 */
	public TokenRefreshResponse(final String pJwt, final Date pExpiration, final String pRefreshToken) {
		super();
		this.jwt = pJwt;
		this.expiration = pExpiration;
		this.refreshToken = pRefreshToken;
	}

	/**
	 * @return the jwt
	 */
	public String getJwt() {
		return jwt;
	}

	/**
	 * @param pJwt the jwt to set
	 */
	public void setJwt(final String pJwt) {
		this.jwt = pJwt;
	}

	/**
	 * @return the expiration
	 */
	public Date getExpiration() {
		return expiration;
	}

	/**
	 * @param pExpiration the expiration to set
	 */
	public void setExpiration(final Date pExpiration) {
		this.expiration = pExpiration;
	}

	/**
	 * @return the refreshToken
	 */
	public String getRefreshToken() {
		return refreshToken;
	}

	/**
	 * @param pRefreshToken the refreshToken to set
	 */
	public void setRefreshToken(final String pRefreshToken) {
		this.refreshToken = pRefreshToken;
	}

}
