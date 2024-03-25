package fr.idformation.pokedex.security.Dto;

import java.util.Date;

public class JwtResponse {

	/** the JWT value. */
	private String jwt;

	/** the expiration date of the JWT. */
	private Date expiration;

	/** the user details. */
	private UserDto user;

	/** the token to use when asking for a new JWT. */
	private String refreshToken;

	/**
	 *
	 */
	public JwtResponse() {
		super();
	}

	/**
	 *
	 * @param pJwt          the jwt token
	 * @param pExpiration   the expiration date of the jwt
	 * @param pUser         the logged user
	 * @param pRefreshToken the refreshToken
	 */
	public JwtResponse(final String pJwt, final Date pExpiration, final UserDto pUser, final String pRefreshToken) {
		super();
		this.jwt = pJwt;
		this.expiration = pExpiration;
		this.user = pUser;
		this.setRefreshToken(pRefreshToken);
	}

	/**
	 * @return the expiration
	 */
	public Date getExpiration() {
		return expiration;
	}

	/**
	 * @return the jwt
	 */
	public String getJwt() {
		return jwt;
	}

	/**
	 * @return the user
	 */
	public UserDto getUser() {
		return user;
	}

	/**
	 * @param pExpiration the expiration to set
	 */
	public void setExpiration(final Date pExpiration) {
		this.expiration = pExpiration;
	}

	/**
	 * @param pJwt the jwt to set
	 */
	public void setJwt(final String pJwt) {
		this.jwt = pJwt;
	}

	/**
	 * @param pUser the user to set
	 */
	public void setUser(final UserDto pUser) {
		this.user = pUser;
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
