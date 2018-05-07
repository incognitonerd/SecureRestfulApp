package com.securerestfulservices.security.configs;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
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
	private static final Logger LOGGER = LoggerFactory.getLogger(SecurityConfig.class);
	@Autowired
	private BasicAuthenticationEntryPoint entryPoint;
	@Autowired
	private AccessDeniedHandler handler;
	@Autowired
	private UserDetailsService userDetailsService;
	
	@Autowired
	public void configureGlobalSecurity(AuthenticationManagerBuilder auth) throws Exception{
		LOGGER.info("celtics");
		auth.userDetailsService(userDetailsService);
	}
	
	@Override
	protected void configure(HttpSecurity http) throws Exception{
		LOGGER.info("warriors");
		http.csrf().disable().authorizeRequests().antMatchers("/SecureRestfulApp/unsecure/showdataset/").permitAll()
				.antMatchers("/secure/**/", "/securetester/**/")
				.hasAnyRole(RoleConstants.ADMIN.toString(), RoleConstants.USER.toString())
				// .antMatchers("/secure/**/", "/securetester/**/").hasRole(RoleConstants.USER.toString())
				.and().httpBasic().authenticationEntryPoint(entryPoint).and().exceptionHandling()
				.accessDeniedHandler(handler);
	}
}