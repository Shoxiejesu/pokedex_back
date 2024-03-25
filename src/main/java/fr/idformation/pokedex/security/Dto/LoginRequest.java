package fr.idformation.pokedex.security.Dto;

public class LoginRequest {

	/** the login received from the caller. */
	private String username;

	/** the password received from the caller. */
	private String password;

	/**
	 *
	 */
	public LoginRequest() {
		super();
	}

	/**
	 * @return the password
	 */
	public String getPassword() {
		return password;
	}

	/**
	 * @return the username
	 */
	public String getUsername() {
		return username;
	}

	/**
	 * @param pPassword the password to set
	 */
	public void setPassword(final String pPassword) {
		this.password = pPassword;
	}

	/**
	 * @param pUsername the username to set
	 */
	public void setUsername(final String pUsername) {
		this.username = pUsername;
	}

}
