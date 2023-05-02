package com.study.springboot.auth;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;

import jakarta.servlet.DispatcherType;

@Configuration
public class WebSecurityConfig {
	@Autowired
	public AuthenticationFailureHandler authFailHandler;
	@Autowired
	public AuthenticationSuccessHandler authSucHandler;

	@Bean
	public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
		System.out.println("기본 컨피그인 filterChain 시작");

		http.csrf().disable().cors().disable()
				.authorizeHttpRequests(request -> request.dispatcherTypeMatchers(DispatcherType.FORWARD).permitAll()
						.requestMatchers("/").permitAll().requestMatchers("/css/**", "/js/**", "/img/**").permitAll()
						.requestMatchers("/guest/**").permitAll().requestMatchers("/member/**")
						.hasAnyRole("USER", "ADMIN").requestMatchers("/admin/**").hasRole("ADMIN").anyRequest()
						.authenticated() // 모든 요청 인증
				).formLogin().loginPage("/loginForm") // default : /login
				.loginProcessingUrl("/j_spring_security_check2")
				// 추가된 부분
				// .failureUrl("/loginError")
				// .failureUrl("/loginForm?error")
				.successHandler(authSucHandler).usernameParameter("j_username").passwordParameter("j_password")
				.failureHandler(authFailHandler)
				// .defaultSuccessUrl("/")
				// .successForwardUrl("/forward")
				.and().logout().logoutUrl("/logout").logoutSuccessUrl("/loginForm").permitAll();

		System.out.println("기본 컨피그인 filterChain 끝");

		return http.build();
	}

	@Bean
	public InMemoryUserDetailsManager userDetailService() {

		System.out.println("기본 컨피그인 유저 정보 시작");
		
		UserDetails guest = User.withUsername("guest")
				.password(passwordEncoder().encode("1234"))
				.roles("GUEST")
				.build();
		UserDetails guest2 = User.withUsername("guest2")
				.password(passwordEncoder().encode("1234"))
				.roles("GUEST")
				.build();
		UserDetails guest3 = User.withUsername("guest3")
				.password(passwordEncoder().encode("1234"))
				.roles("GUEST")
				.build();
		UserDetails user = User.withUsername("user")
				.password(passwordEncoder().encode("1234"))
				.roles("USER")
				.build();
		UserDetails admin = User.withUsername("admin")
				.password(passwordEncoder().encode("1234"))
				.roles("ADMIN")
				.build();
		UserDetails admin2 = User.withUsername("admin2")
				.password(passwordEncoder().encode("1234"))
				.roles("ADMIN")
				.build();
		UserDetails admin3 = User.withUsername("admin3")
				.password(passwordEncoder().encode("1234"))
				.roles("ADMIN")
				.build();
		
		UserDetails[] userDetails = new UserDetails[7];
		userDetails[0] = guest;
		userDetails[1] = guest2;
		userDetails[2] = guest3;
		userDetails[3] = user;
		userDetails[4] = admin;
		userDetails[5] = admin2;
		userDetails[6] = admin3;
		System.out.print(">> ");
		System.out.print(passwordEncoder().encode("1234"));
		System.out.println(" << ");
		System.out.println("기본 컨피그인 유저 정보 끝");

		return new InMemoryUserDetailsManager(userDetails);
	}

	@Bean
	public BCryptPasswordEncoder passwordEncoder() {
		System.out.println("기본 컨피그인 패스워드 디코드 시작");
		return new BCryptPasswordEncoder();
		// StandardPasswordEncoder()-SHA256
		// NoOpPasswordEncoder()-암호화하지 않은 데이터
	}
}
