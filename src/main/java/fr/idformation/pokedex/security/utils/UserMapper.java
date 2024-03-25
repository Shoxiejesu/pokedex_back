package fr.idformation.pokedex.security.utils;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.security.core.authority.SimpleGrantedAuthority;

import fr.idformation.pokedex.security.models.User;

public class UserMapper {

	/**
	 * Map a user into userPrincipal.
	 *
	 * @param user a user to map
	 * @return a userPrincipal
	 */
	public static UserPrincipal userToPrincipal(final User user) {
		UserPrincipal userp = new UserPrincipal();
		List<SimpleGrantedAuthority> authorities = user.getRoles().stream()
				.map(role -> new SimpleGrantedAuthority("ROLE_" + role.getName())).collect(Collectors.toList());

		userp.setUsername(user.getUsername());
		userp.setPassword(user.getPassword());
		userp.setEnabled(true);
		userp.setAuthorities(authorities);
		return userp;
	}
}
