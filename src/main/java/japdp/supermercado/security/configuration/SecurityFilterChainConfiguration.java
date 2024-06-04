package japdp.supermercado.security.configuration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import japdp.supermercado.security.jwt.JwtAuthenticationFilter;
import lombok.RequiredArgsConstructor;

/**
 * Configuración de la cadena de filtros de seguridad.
 */
@Configuration
@EnableWebSecurity
@RequiredArgsConstructor
public class SecurityFilterChainConfiguration {

	@Autowired
	private final JwtAuthenticationFilter jwtAuthenticationFilter;
	@Autowired
	private final AuthenticationProvider authenticationProvider;

	/**
	 * Configura la cadena de filtros de seguridad
	 *
	 * @param httpSecurityFilterChainBuilder Configurador de la cadena de filtros de
	 *                                       seguridad HTTP.
	 * @return Configuración de la cadena de filtros de seguridad.
	 * @throws Exception Si hay un error en la configuración de seguridad.
	 */
	  @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity httpSecurityFilterChainBuilder) throws Exception {
    
	      return httpSecurityFilterChainBuilder.csrf(csrfConfigurer -> csrfConfigurer.disable())

				    .authorizeHttpRequests(registry -> 
                registry.requestMatchers("/auth/**","/react/**").permitAll()
                        .anyRequest().authenticated()
            )
           
				    .authenticationProvider(authenticationProvider)
				    
				    .cors(Customizer.withDefaults())

			      .sessionManagement(	httpSecuritySessionManagementConfigurer -> 
				        httpSecuritySessionManagementConfigurer.sessionCreationPolicy(SessionCreationPolicy.STATELESS)
				    )

				    .addFilterBefore(jwtAuthenticationFilter, UsernamePasswordAuthenticationFilter.class)

				    .build();
				
   }

}
