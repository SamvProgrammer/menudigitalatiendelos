package com.restaurants.menu;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.User.UserBuilder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
public class seguridadConfiguracion extends WebSecurityConfigurerAdapter{

	
	@Bean
	public BCryptPasswordEncoder codificadorPassword() {
		return new BCryptPasswordEncoder();
	}
	
	@Autowired
	public void configuracionGlobal(AuthenticationManagerBuilder builder) throws Exception {
		PasswordEncoder password = this.codificadorPassword();
		
		UserBuilder usuarios = User.builder().passwordEncoder(password::encode);
		
		builder.inMemoryAuthentication().withUser(usuarios.username("superadmin").password("dondecomer12345").roles("ADMIN","USER"));
		
		
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		 http.csrf().disable().authorizeRequests()
		 .antMatchers(HttpMethod.GET,"/{\\d+}","/{\\d+}/perfil","/{\\d+}/perfil","/{\\d+}/ordenpaso3","/{\\d+}/perfil","/{\\d+}/ordenpaso2","/{\\d+}/perfil","/{\\d+}/ordenpaso1","/","/index","/listarestaurantes/**",
				 "/css/**","/fonts/**","/img/**","/js/**","/video/**","/productoimagenes/**","/restaurantesimagenes/**","/api/**","/restaurantes/logo/**").permitAll()
		 .antMatchers(HttpMethod.POST,"/api/**","/admin/**").hasAnyRole("ADMIN","USER")
		 .antMatchers(HttpMethod.PUT,"/api/**","/admin/**").hasAnyRole("ADMIN","USER")
		 .antMatchers(HttpMethod.DELETE,"/api/**","/admin/**").hasAnyRole("ADMIN","USER").anyRequest().authenticated()
		 .and().formLogin().and().logout();
	}
	
	
	
}