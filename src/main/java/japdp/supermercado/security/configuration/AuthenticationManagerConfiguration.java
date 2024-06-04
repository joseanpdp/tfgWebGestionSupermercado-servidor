package japdp.supermercado.security.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;

import lombok.RequiredArgsConstructor;

/**
 * Configuración del administrador de autenticación.
 */
@Configuration
@RequiredArgsConstructor
public class AuthenticationManagerConfiguration {

	/**
	 * Configura y proporciona el administrador de autenticación.
	 *
	 * @param authenticationConfiguration Configuración de autenticación.
	 * @return Administrador de autenticación configurado.
	 * @throws Exception Si hay un error al obtener el administrador de
	 *                   autenticación.
	 */
	@Bean
	public AuthenticationManager authenticationManager(AuthenticationConfiguration authenticationConfiguration)
			throws Exception {
		return authenticationConfiguration.getAuthenticationManager();
	}

}
