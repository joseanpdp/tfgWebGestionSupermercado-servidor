/**
 * DTO (Data Transfer Object) para la solicitud de registro de usuario.
 */
package japdp.supermercado.security.authentication.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class RegisterRequestDTO {
	/**
	 * Nombre de usuario proporcionado durante el registro.
	 */
	private String username;

	/**
	 * Contraseña proporcionada durante el registro.
	 */
	private String password;

	/**
	 * Correo electrónico proporcionado durante el registro.
	 */
	private String email;

	/**
	 * Descripción proporcionada durante el registro.
	 */
	private String description;

	/**
	 * Fecha de creación proporcionada durante el registro.
	 */
	private String creationDate;
}
