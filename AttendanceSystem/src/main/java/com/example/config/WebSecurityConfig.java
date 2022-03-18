package com.example.config;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.servlet.mvc.WebContentInterceptor;

@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter 
{
  @Autowired
  private UserDetailsService userDetailsService;
  
  @Bean
  public BCryptPasswordEncoder passwordEncoder()
  {
    return new BCryptPasswordEncoder();
  };
  
  @Override
  protected void configure(AuthenticationManagerBuilder auth) throws Exception {
    auth.userDetailsService(userDetailsService).passwordEncoder(passwordEncoder());
  }

  @Override
  protected void configure(HttpSecurity http) throws Exception 
  {
	  http.authorizeRequests()
	  .antMatchers("/faculty/").authenticated()
	  .antMatchers("/comment/add").authenticated()
	  .antMatchers("/comment/").authenticated()
      .antMatchers("/product/add/**").hasAuthority("admin")
      .antMatchers("/faculty/delete/**").hasAuthority("admin")
      .antMatchers("/faculty/edit/**").hasAuthority("admin")
      .antMatchers("/faculty/edit/**").hasAuthority("admin")
      .antMatchers("/Import/**").hasAuthority("teacher")
      .and().formLogin()
      
      .defaultSuccessUrl("/")
      .loginPage("/faculty/login").loginProcessingUrl("/faculty/loginaction").permitAll().failureUrl("/faculty/login-error")
      .and()
      .logout().logoutUrl("/faculty/logout")
      .invalidateHttpSession(true)
      .clearAuthentication(true)
      .deleteCookies("JESSIONID")
      .logoutSuccessUrl("/faculty/login")
      .and().csrf().disable();
  }
}