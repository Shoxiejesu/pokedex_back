package fr.idformation.pokedex.security.jwt;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.util.StringUtils;
import org.springframework.web.filter.OncePerRequestFilter;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public final class JwtAuthenticationFilter extends OncePerRequestFilter {

	/** A token header set in the app parameters. */
	@Value("${app.jwtTokenHeader}")
	private String tokenHeader;

	/** a jwt token provider. */
	@Autowired
	private JwtProvider tokenProvider;

	/** a service able to provide access to the users details. */
	@Autowired
	private UserDetailsService userDetailsService;

	@Override
	protected void doFilterInternal(final HttpServletRequest request, final HttpServletResponse response,
			final FilterChain filterChain) throws ServletException, IOException {
		try {
			String jwt = getJwtFromRequest(request);
			if (StringUtils.hasText(jwt) && tokenProvider.validateToken(jwt)) {
				String username = tokenProvider.getUserUsernameFromJWT(jwt);
				UserDetails userDetails = userDetailsService.loadUserByUsername(username);
				UsernamePasswordAuthenticationToken authentication = new UsernamePasswordAuthenticationToken(
						userDetails, null, userDetails.getAuthorities());
				authentication.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
				SecurityContextHolder.getContext().setAuthentication(authentication);
			}
		} catch (Exception ex) {
			logger.error("Could not set user authentication in security context", ex);
		}
		filterChain.doFilter(request, response);
	}

	private String getJwtFromRequest(final HttpServletRequest request) {
		String bearerToken = request.getHeader("Authorization");
		if (StringUtils.hasText(bearerToken) && bearerToken.startsWith(tokenHeader)) {
			return bearerToken.substring(tokenHeader.length() + 1, bearerToken.length());
		}
		return null;
	}
}
