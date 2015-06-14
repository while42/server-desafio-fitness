package br.com.while42.treinofitness;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.annotation.web.servlet.configuration.EnableWebMvcSecurity;

@Configuration
@EnableWebMvcSecurity
public class SecurityConfiguration extends WebSecurityConfigurerAdapter 
{
	public static final String SESSIONCOOKIENAME = "TREINOFITNESSID";
	
	@Override
	protected void configure(AuthenticationManagerBuilder auth)
			throws Exception {
	}

	@Override
	public void configure(WebSecurity web) throws Exception {
	}
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {

		http
        .authorizeRequests()
            .antMatchers("/", "/api", "/api/status", "/resources/**").permitAll()
            .anyRequest().permitAll();

		http
		.formLogin()
            .loginPage("/login")
            .permitAll();
		
		http
        .logout()
            .permitAll()
            .invalidateHttpSession( true )
            .deleteCookies(SESSIONCOOKIENAME);
		
		http
        .csrf()
            .disable();;
            
        // TODO: Somente para desenvolvimento
        http.authorizeRequests().anyRequest().anonymous();    
	}
}
