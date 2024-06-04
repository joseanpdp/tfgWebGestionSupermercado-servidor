/**
 * DTO (Data Transfer Object) para la solicitud de inicio de sesión.
 */
package japdp.supermercado.security.authentication.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class LoginRequestDTO {
	/**
	 * Nombre de usuario proporcionado durante el inicio de sesión.
	 */
	private String username;

	/**
	 * Contraseña proporcionada durante el inicio de sesión.
	 */
	private String password;
}
