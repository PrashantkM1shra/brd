package com.nucleus.security;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.nucleus.service.LoginAuthenticationService;

@Configuration
@EnableWebSecurity
public class WebSecurityConfiguration extends WebSecurityConfigurerAdapter {
	
	/*@Autowired
    DbAuthenticationService dbAuthenticationService;*/
	@Autowired
	DataSource dataSource;
	 
	@Autowired
	AuthenticRedirectionHandler authenticRedirectionHandler;
 
    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
 
        // Users in memory.
 
        /*auth.inMemoryAuthentication().withUser("User").password("5678").roles("USER");
        auth.inMemoryAuthentication().withUser("Admin").password("1234").roles("ADMIN");
        */
    	auth.jdbcAuthentication().dataSource(dataSource)
    	.passwordEncoder(passwordEncoder())
    	.usersByUsernameQuery("select username,password,enabled from AuthenticUsers02 where username=?")
    	.authoritiesByUsernameQuery("select username,USER_ROLE from AuthenticUsers02 where username=?").getUserDetailsService();
        // For User in database.
        //auth.userDetailsService(dbAuthenticationService);
 
    }
    
    @Bean
	public PasswordEncoder passwordEncoder(){
		PasswordEncoder encoder = new BCryptPasswordEncoder();
		return encoder;
	}
    
    @Override
    protected void configure(HttpSecurity http) throws Exception {
 
        http.csrf().disable();
        
        http.headers().frameOptions().sameOrigin();
 
        // The pages does not require login
        http.authorizeRequests().antMatchers("/", "/login", "/logout").permitAll();
 
        // /userInfo page requires login as USER or ADMIN.
        // If no login, it will redirect to /login page
        http.authorizeRequests().antMatchers("/userInfo", "/*customer*", "/*Customer*" ).access("hasRole('ROLE_USER')");
 
        // For ADMIN only.
        http.authorizeRequests().antMatchers("/admin", "/*user*", "/*User*").access("hasRole('ROLE_ADMIN')");
 
        // When the user has logged in as XX.
        // But access a page that requires role YY,
        // AccessDeniedException will throw.
        http.authorizeRequests().and().exceptionHandling().accessDeniedPage("/403");
 
        // Config for Login Form
        http.authorizeRequests().and().formLogin()//
                // Submit URL of login page.
                .loginProcessingUrl("/j_spring_security_check") // Submit URL
                .loginPage("/login")//
                .defaultSuccessUrl("/userInfo")//
                .failureUrl("/login?error=true")
                .successHandler(authenticRedirectionHandler)//
                .usernameParameter("username")//
                .passwordParameter("password")
                // Config for Logout Page
                .and().logout().logoutUrl("/logout").logoutSuccessUrl("/logoutSuccessful");
 
    }
}

