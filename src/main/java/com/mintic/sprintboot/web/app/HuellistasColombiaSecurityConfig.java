package com.mintic.sprintboot.web.app;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

import com.mintic.sprintboot.web.app.auth.handler.LoginCustomSuccesHandler;
import com.mintic.sprintboot.web.app.models.services.JpaUserDetailsService;

@EnableGlobalMethodSecurity(prePostEnabled = true, securedEnabled = true)
@Configuration
public class HuellistasColombiaSecurityConfig extends WebSecurityConfigurerAdapter{

	@Autowired
	private LoginCustomSuccesHandler successHandler;
	
	@Autowired
	private JpaUserDetailsService userDetailsService;
		
	@Autowired
	private BCryptPasswordEncoder passwordEncoder;
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.authorizeRequests().antMatchers("/", "/post/list/**", "/post/view/**", "/post/filter/**", "/fonts/**", "/img/**", "/uploads/**", "/css/**", "/js/**", "/images/**", "/profile/register").permitAll()
		/*.antMatchers("/register").hasAuthority("ADMIN")*/
		.anyRequest().authenticated()
		.and()
			.formLogin()
				.loginPage("/login")
				.successHandler(successHandler)
				.permitAll()
		.and()
			.logout()
				.logoutRequestMatcher(new AntPathRequestMatcher("/logout"))
				.logoutSuccessUrl("/login")
				.permitAll()
		.and()
			.exceptionHandling().accessDeniedPage("/error_403");
	}

	@Autowired
	public void configurerGlobal(AuthenticationManagerBuilder builder) throws Exception{
		builder.userDetailsService(userDetailsService)
			.passwordEncoder(passwordEncoder);
	}
}