package com.spring.covidsupport.config;

import com.spring.covidsupport.constant.RoleName;
import com.spring.covidsupport.filter.JwtRequestFilter;
import com.spring.covidsupport.service.impl.MyUserDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {
  private static final String[] AUTH_WHITELIST = {
    // -- Swagger UI v2
    "/v2/api-docs",
    "/swagger-resources",
    "/swagger-resources/**",
    "/configuration/ui",
    "/configuration/security",
    "/swagger-ui.html",
    "/webjars/**",
    // -- Swagger UI v3 (OpenAPI)
    "/v3/api-docs/**",
    "/swagger-ui/**",
    // other public endpoints of your API may be appended to this array
    "/api/v1/auth/**",
    "/api/v1/ward",
    "/api/v1/district",
    "/api/v1/ward/**",
    "/api/v1/district/**"
  };
  @Autowired private MyUserDetailsService myUserDetailsService;
  @Autowired private JwtRequestFilter jwtRequestFilter;

  @Override
  protected void configure(AuthenticationManagerBuilder auth) throws Exception {
    auth.userDetailsService(myUserDetailsService);
  }

  @Override
  protected void configure(HttpSecurity http) throws Exception {
    http.csrf()
        .disable()
        .authorizeRequests()
        .antMatchers(AUTH_WHITELIST)
        .permitAll()
        .antMatchers("/api/v1/admin/**")
        .hasAnyAuthority(RoleName.ROLE_ADMIN.name())
        .antMatchers("/api/v1/manager/**")
        .hasAnyAuthority(RoleName.ROLE_MANAGER.name(), RoleName.ROLE_ADMIN.toString())
        .anyRequest()
        .authenticated()
        .and()
        .sessionManagement()
        .sessionCreationPolicy(SessionCreationPolicy.STATELESS);
    http.addFilterBefore(jwtRequestFilter, UsernamePasswordAuthenticationFilter.class);
  }

  // .antMatchers("api/admin/*").access("hasAnyRole(ROLE_ADMIN)")
  @Override
  @Bean
  public AuthenticationManager authenticationManagerBean() throws Exception {
    return super.authenticationManagerBean();
  }

  @Bean
  public DaoAuthenticationProvider authProvider() {
    DaoAuthenticationProvider authProvider = new DaoAuthenticationProvider();
    authProvider.setUserDetailsService(myUserDetailsService);
    authProvider.setPasswordEncoder(passWordEncoder());
    return authProvider;
  }

  @Bean
  public PasswordEncoder passWordEncoder() {
    return new BCryptPasswordEncoder();
  }
}
