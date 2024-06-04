package japdp.supermercado.security.configuration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;

import lombok.RequiredArgsConstructor;

/**
 * Configuración del proveedor de autenticación.
 */
@Configuration
@RequiredArgsConstructor
public class AuthenticationProviderConfiguration {

	@Autowired
	private final UserDetailsService userDetailsService;
	@Autowired
	private final PasswordEncoder passwordEncoder;

	/**
	 * Configura y proporciona el proveedor de autenticación.
	 *
	 * @return Proveedor de autenticación configurado.
	 */
	@Bean
	public AuthenticationProvider authenticationProvider() {
		DaoAuthenticationProvider authenticationProvider = new DaoAuthenticationProvider();
		authenticationProvider.setUserDetailsService(userDetailsService);
		authenticationProvider.setPasswordEncoder(passwordEncoder);
		return authenticationProvider;
	}

}
