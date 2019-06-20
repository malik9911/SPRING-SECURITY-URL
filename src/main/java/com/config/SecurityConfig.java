package com.config;



import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;



@Configuration
@EnableWebSecurity
public class SecurityConfig extends  WebSecurityConfigurerAdapter {
	
	
	//used to permit these url to all user with security 

//	@Override	
//	protected void configure(HttpSecurity http)throws Exception{
//			http.authorizeRequests().antMatchers("/", "/api/**").permitAll().anyRequest().authenticated();
//			http.httpBasic();
//		}
/**
 * it used to set these url should be access to any users.	
 */

	
//	@Override	
//	protected void configure(HttpSecurity http)throws Exception{
//			http.authorizeRequests().antMatchers("/", "/api/**").access("hasRole('USER')").antMatchers("/admin/**").access("hasRole('ADMIN')");
//			http.httpBasic();
//		}
	
	/**
	 * it used to set that  /admin/ url should be access by admin user with credentials.
	 * @param http
	 * @throws Exception
	 */
	@Override	
	protected void configure(HttpSecurity http)throws Exception{
			http.authorizeRequests().antMatchers("/admin/**").access("hasRole('ADMIN')");
			http.httpBasic();
		}


	/**
	 * 
	 * @param builder object of AuthenticationManagerBuilder
	 * @throws Exception
	 */
	protected void configure(AuthenticationManagerBuilder builder) throws Exception {	
		//builder.inMemoryAuthentication().withUser("abc").password("abc").roles("USER");
		builder.inMemoryAuthentication().withUser("admin").password("admin").roles("ADMIN");
	}
	
    /**
     * used to explicitly decode password only for spring version 5 and up.	
     * @return
     */
	@SuppressWarnings("deprecation")
	@Bean
	public static NoOpPasswordEncoder passwordEncoder() {
	return (NoOpPasswordEncoder) NoOpPasswordEncoder.getInstance();
	}
	
	
}
