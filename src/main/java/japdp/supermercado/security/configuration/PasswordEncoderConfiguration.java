package japdp.supermercado.security.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

/**
 * Configuración del codificador de contraseñas.
 */
@Configuration
public class PasswordEncoderConfiguration {

	/**
	 * Configura y proporciona un codificador de contraseñas BCrypt.
	 *
	 * @return Codificador de contraseñas BCrypt configurado.
	 */
	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}

}
