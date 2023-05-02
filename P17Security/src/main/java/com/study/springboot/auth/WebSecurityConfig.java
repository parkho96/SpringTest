package com.study.springboot.auth;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

import jakarta.servlet.DispatcherType;
import lombok.extern.java.Log;
import lombok.extern.slf4j.Slf4j;

@Configuration
@Slf4j
public class WebSecurityConfig {

//	@Bean
//	public SecurityFilterChain filterChain(HttpSecurity http) throws Exception{
//		log.info("컨피그 filterChain 입력 전 1");
//        http.csrf().disable().cors().disable();
//        http.authorizeHttpRequests(request -> request
//        	.dispatcherTypeMatchers(DispatcherType.FORWARD).permitAll()
//        	.requestMatchers("/").permitAll()
//        	.requestMatchers("/css/**","/js/**","/img/**").permitAll()
//        	.requestMatchers("/guest/**").permitAll()
//        	.requestMatchers("/member/**").hasAnyRole("USER","ADMIN")
////        	.requestMatchers("/member/**").hasAnyRole("ADMIN")
//        	.requestMatchers("/admin/**").hasRole("ADMIN")
//        	.anyRequest().authenticated() //모든 요청 인증
//        	);
//        http.formLogin().permitAll();
//        http.logout().permitAll();
//        log.info("컨피그 filterChain 입력 후 1");
//        return http.build();
//	}

	// 한 줄로 요약함!
	@Bean
	public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
		log.info("컨피그 filterChain 입력 전 1");
		return http.csrf().disable().cors().disable()
				.authorizeHttpRequests(request -> request.dispatcherTypeMatchers(DispatcherType.FORWARD).permitAll()
						.requestMatchers("/").permitAll()
						.requestMatchers("/css/**", "/js/**", "/img/**").permitAll()
						.requestMatchers("/guest/**").permitAll()
						.requestMatchers("/member/**").hasAnyRole("USER", "ADMIN")
						.requestMatchers("/admin/**").hasRole("ADMIN")
						.anyRequest().authenticated() // 모든 요청 인증
				).formLogin().permitAll()
				 .and().logout().permitAll()
				 .and().build();
	}

	@Bean
	public InMemoryUserDetailsManager userDetailService() {
		log.info("컨피그 userDetailService 입력 전 2");
		UserDetails user = User.withUsername("user2")
								.password(passwordEncoder().encode("1234"))
								.roles("USER")
								.build();
		UserDetails admin = User.withUsername("admin")
								.password(passwordEncoder().encode("1234"))
								.roles("ADMIN")
								.build();
		UserDetails guest = User.withUsername("guest")
								.password(passwordEncoder().encode("1234"))
								.roles("ADMIN")
								.build();

		
		UserDetails[] userDetails = new UserDetails[3];
		userDetails[0] = user;
		userDetails[1] = admin;
		userDetails[2] = guest;
		System.out.print(">> ");
		System.out.print(passwordEncoder().encode("1234"));
		System.out.println(" << ");
		log.info("컨피그 userDetailService 입력 후 2");
		return new InMemoryUserDetailsManager(userDetails);
	}

	@Bean
	public BCryptPasswordEncoder passwordEncoder() {
		log.info("컨피그 BCryptPasswordEncoder 3");
		return new BCryptPasswordEncoder();
		// StandardPasswordEncoder()-SHA256
		// NoOpPasswordEncoder()-암호화하지 않은 데이터
	}
}
