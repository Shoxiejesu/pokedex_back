package fr.idformation.pokedex.security.models;

import java.time.Instant;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "refresh_token")
public class RefreshToken {

	/** the user. */
	@OneToOne
	@JoinColumn(name = "user_id", referencedColumnName = "id")
	private User user;

	/** the refresh token. */
	@Id
	@Column(nullable = false, unique = true)
	private String token;

	/** the expiration date. */
	@Column(name = "expirity_date", nullable = false)
	private Instant expirityDate;

	// getters and setters

	/**
	 * @return the user
	 */
	public User getUser() {
		return user;
	}

	/**
	 * @param pUser the user to set
	 */
	public void setUser(final User pUser) {
		this.user = pUser;
	}

	/**
	 * @return the token
	 */
	public String getToken() {
		return token;
	}

	/**
	 * @param pToken the token to set
	 */
	public void setToken(final String pToken) {
		this.token = pToken;
	}

	/**
	 * @return the expiryDate
	 */
	public Instant getExpirityDate() {
		return expirityDate;
	}

	/**
	 * @param pExpiryDate the expiryDate to set
	 */
	public void setExpirityDate(final Instant pExpiryDate) {
		this.expirityDate = pExpiryDate;
	}

}
