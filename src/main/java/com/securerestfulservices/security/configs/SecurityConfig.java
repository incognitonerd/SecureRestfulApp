package com.securerestfulservices.security.configs;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.web.access.AccessDeniedHandler;
import org.springframework.security.web.authentication.www.BasicAuthenticationEntryPoint;
import com.securerestfulservices.utils.RoleConstants;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {
	@Autowired
	private BasicAuthenticationEntryPoint entryPoint;
	@Autowired
	private AccessDeniedHandler handler;
	@Autowired
	private UserDetailsService userDetailsService;
	
	@Autowired
	public void configureGlobalSecurity(AuthenticationManagerBuilder auth) throws Exception{
		auth.userDetailsService(userDetailsService);
		System.out.println("celtics");
	}
	
	@Override
	protected void configure(HttpSecurity http) throws Exception{
		http.headers().cacheControl().disable();
		
		System.out.println("warriors");
		http.csrf().disable().authorizeRequests().antMatchers("/securetester/user/count").permitAll()
				.antMatchers("/securetester/user/profile").hasRole(RoleConstants.USER.toString())
				.antMatchers("/securetester/user/**").hasRole(RoleConstants.ADMIN.toString())
				.antMatchers("/secure/randomqueries/").hasRole(RoleConstants.USER.toString())
				.antMatchers("/secure/randomqueries/").hasRole(RoleConstants.ADMIN.toString()).and().httpBasic()
				.authenticationEntryPoint(entryPoint).and().exceptionHandling().accessDeniedHandler(handler);
	}
}