/**
 * Servicio para la gestión de tokens JWT.
 */
package japdp.supermercado.security.jwt;

import java.security.Key;
import java.util.Date;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;

@Service
public class JwtService {

	private static final String SECRET_KEY = "586E3272357538782F413F4428472B4B6250655368566B597033733676397924";

	/**
	 * Genera un token JWT para el usuario proporcionado.
	 *
	 * @param user Detalles del usuario.
	 * @return Token JWT generado.
	 */
	public String getToken(UserDetails user) {
		return Jwts.builder().setSubject(user.getUsername()).setIssuedAt(new Date(System.currentTimeMillis()))
				.setExpiration(new Date(System.currentTimeMillis() + 1000 * 60 * 24))
				.signWith(getKey(), SignatureAlgorithm.HS256).compact();
	}

	/**
	 * Verifica si un token JWT es válido para los detalles del usuario
	 * proporcionados.
	 *
	 * @param token       Token JWT a verificar.
	 * @param userDetails Detalles del usuario.
	 * @return true si el token es válido, false en caso contrario.
	 */
	public boolean isTokenValid(String token, UserDetails userDetails) {
		final String username = getUsernameFromToken(token);
		return (username.equals(userDetails.getUsername()) && !isTokenExpired(token));
	}

	/**
	 * Obtiene el nombre de usuario almacenado en un token JWT.
	 *
	 * @param token Token JWT.
	 * @return Nombre de usuario.
	 */
	public String getUsernameFromToken(String token) {
		final Claims claims = getClaims(token);
		return claims.getSubject();
	}

	/**
	 * Obtiene los reclamos (claims) de un token JWT.
	 *
	 * @param token Token JWT.
	 * @return Claims del token.
	 */
	private Claims getClaims(String token) {
		return Jwts.parserBuilder().setSigningKey(getKey()).build().parseClaimsJws(token).getBody();
	}

	/**
	 * Obtiene la clave utilizada para firmar los tokens JWT.
	 *
	 * @return Clave de firma.
	 */
	private Key getKey() {
		byte[] keyBytes = Decoders.BASE64.decode(SECRET_KEY);
		return Keys.hmacShaKeyFor(keyBytes);
	}

	/**
	 * Verifica si un token JWT ha expirado.
	 *
	 * @param token Token JWT.
	 * @return true si el token ha expirado, false en caso contrario.
	 */
	private boolean isTokenExpired(String token) {
		final Claims claims = getClaims(token);
		Date expiration = claims.getExpiration();
		return expiration.before(new Date());
	}

}
