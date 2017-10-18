package co.edu.ufps.condominio.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import co.edu.ufps.condominio.servicios.impl.UserServicioImpl;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled=true)
public class SecurityConfig extends WebSecurityConfigurerAdapter {
	
	@Autowired
	@Qualifier("UserServicioImpl")
	private UserServicioImpl userServicioImpl;
	
	@Autowired
	public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
		auth.userDetailsService(userServicioImpl).passwordEncoder(new BCryptPasswordEncoder());
	}
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.authorizeRequests()
		  .antMatchers("/css/**","/fonts/**","/js/**","/vendor/**").permitAll()
		  .anyRequest().authenticated()
		  .and().csrf().disable()
		.formLogin().loginPage("/seguridad/login").loginProcessingUrl("/seguridad/autentificar")
		.usernameParameter("username").passwordParameter("password")
		.defaultSuccessUrl("/",true).permitAll()
		.and()
		.logout().logoutUrl("/seguridad/logout").clearAuthentication(true)
		.invalidateHttpSession(true)
		.logoutSuccessUrl("/seguridad/login?logout").permitAll();
		super.configure(http);
	}

}
