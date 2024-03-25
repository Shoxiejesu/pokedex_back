package fr.idformation.pokedex.security;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.ProviderManager;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;

import fr.idformation.pokedex.security.jwt.JwtAuthenticationFilter;
import jakarta.servlet.http.HttpServletResponse;

@Configuration
@EnableMethodSecurity
public class SecurityConfiguration {

	/** import the userdetailservice. */
	@Autowired
	private UserDetailsService userDetailsService;

	/**
	 * @return an AuthenticationManager
	 */
	@Bean
	public AuthenticationManager authenticationManager() {
		DaoAuthenticationProvider authProvider = new DaoAuthenticationProvider();
		authProvider.setUserDetailsService(userDetailsService);
		authProvider.setPasswordEncoder(new BCryptPasswordEncoder());

		return new ProviderManager(authProvider);
	}

	/**
	 * @param http an http to configure
	 * @return a SecurityFilterChain
	 * @throws Exception
	 */
	@Bean
	public SecurityFilterChain filterChain(final HttpSecurity http) throws Exception {

		http.cors(Customizer.withDefaults());
		http.csrf((csrf) -> csrf.disable());
		http.exceptionHandling((exceptionHandling) -> exceptionHandling.authenticationEntryPoint((req, res, ex) -> res
				.sendError(HttpServletResponse.SC_UNAUTHORIZED, "UNAUTHORIZED : " + ex.getMessage())));

		http.sessionManagement((session) -> session.sessionCreationPolicy(SessionCreationPolicy.STATELESS));

		http.addFilterBefore(jwtAuthenticationFilter(), UsernamePasswordAuthenticationFilter.class);

		// set required security based on request
		http.authorizeHttpRequests(req -> req.requestMatchers("/ping").permitAll());
		http.authorizeHttpRequests(req -> req.requestMatchers("/auth/**").permitAll());
		http.authorizeHttpRequests(req -> req.requestMatchers("/settings/logo").permitAll());
		http.authorizeHttpRequests(req -> req.anyRequest().authenticated());

		return http.build();
	}

	/**
	 * @return a JwtAuthenticationFilter
	 */
	@Bean
	public JwtAuthenticationFilter jwtAuthenticationFilter() {
		return new JwtAuthenticationFilter();
	}

	/**
	 *
	 * @return a configuration for the cors
	 */
	@Bean
	CorsConfigurationSource corsConfigurationSource() {
		CorsConfiguration configuration = new CorsConfiguration();
		configuration.setAllowedOrigins(Arrays.asList("*"));
		configuration.setAllowedMethods(Arrays.asList("*"));
		configuration.setAllowedHeaders(Arrays.asList("*"));
		UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();

		source.registerCorsConfiguration("/**", configuration);

		return source;
	}

}
