package fr.idformation.pokedex.security.Dto;

import jakarta.validation.constraints.NotBlank;

public class TokenRefreshRequest {
	/** the refresk token. */
	@NotBlank
	private String refreshToken;

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
