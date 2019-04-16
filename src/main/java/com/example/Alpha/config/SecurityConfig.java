package com.example.Alpha.config;

// import javax.annotation.security.RolesAllowed;

import com.example.Alpha.security.CustomUserDetailsService;
import com.example.Alpha.security.JwtAuthenticationEntryPoint;
import com.example.Alpha.security.JwtAuthenticationFilter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
// import org.springframework.security.access.annotation.Secured;
// import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.BeanIds;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
// import org.springframework.security.core.userdetails.User;
// import org.springframework.security.core.userdetails.UserDetails;
// import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
// import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
@EnableWebSecurity
// EnableWebSecurity은 프로젝트에서 웹 보안을 가능하게하는 데 사용되는 기본 스프링 보안 주석입니다.
@EnableGlobalMethodSecurity(securedEnabled = true, jsr250Enabled = true, prePostEnabled = true)
// EnableGlobalMethodSecurity는 주석에 기반한 메소드 레벨 보안 을 가능하게 하는 데 사용됩니다 .
// 메소드 보안을 위해 다음 세 가지 유형의 주석을 사용할 수 있습니다.
// WebSecurityConfigurerAdapter 클래스는 Spring Security의 WebSecurityConfigurer인터페이스를 구현 한다.
// 기본 보안 구성을 제공하며 다른 클래스가이 클래스를 확장하고 해당 메서드를 재정 의하여 보안 구성을 사용자 지정할 수 있습니다.
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private CustomUserDetailsService customUserDetailsService;
    //사용자를 인증하거나 다양한 역할 기반 검사를 수행하기 위해 Spring 보안은 어떻게 든 사용자 세부 사항을로드해야합니다.
    //이 목적을 위해서, 이것은 UserDetailsServiceusername이라는 이름을 기반으로 사용자를로드하는 단일 메소드를 가진 호출 된 인터페이스로 구성됩니다.
    @Autowired
    private JwtAuthenticationEntryPoint unauthorizedHandler;
    //이 클래스는 적절한 인증없이 보호 된 자원에 액세스하려고 시도하는 클라이언트에게 401 권한이 부여되지 않은 오류를 반환하는 데 사용됩니다. 
    //그것은 Spring Security의 AuthenticationEntryPoint인터페이스를 구현 합니다.

    // // securedEnabled
    // @Secured("ROLE_ADMIN")
    // public User getAllUsers() {
    // }

    // @Secured({ "ROLE_USER", "ROLE_ADMIN" })
    // public User getUser(Long id) {
    // }

    // @Secured("IS_AUTHENTICATED_ANONYMOUSLY")
    // public boolean isUsernameAvailable() {
    // }

    // // jsr250Enabled
    // @RolesAllowed("ROLE_ADMIN")
    // public Poll createPoll() {
    // }

    // // prePostEnabled
    // @PreAuthorize("isAnonymous()")
    // public boolean isUsernameAvailable() {
    // }

    // @PreAuthorize("hasRole('USER')")
    // public Poll createPoll() {
    // }

    @Bean
    public JwtAuthenticationFilter jwtAuthenticationFilter() {
        return new JwtAuthenticationFilter();
    }
//     JWTAuthenticationFilter필터를 구현하는 데 사용 합니다.
// Authorization모든 요청 의 헤더 에서 JWT 인증 토큰을 읽습니다.
// 토큰의 유효성을 검사하다
// 해당 토큰과 연관된 사용자 세부 사항을로드합니다.
// Spring Security의 사용자 세부 사항을 설정합니다 SecurityContext. 스프링 시큐리티는 사용자 세부 정보를 사용하여 권한 검사를 수행합니다. 또한 SecurityContext컨트롤러에 저장된 사용자 세부 정보에 액세스하여 비즈니스 논리를 수행 할 수 있습니다.

    @Override
    public void configure(AuthenticationManagerBuilder authenticationManagerBuilder) throws Exception {
        authenticationManagerBuilder
                .userDetailsService(customUserDetailsService) // 입력된 user에 대한 상세정보
                .passwordEncoder(passwordEncoder()); //password를 encorder하는 방식을 정함
    }
// AuthenticationManagerBuilder는 AuthenticationManager사용자를 인증하기위한 주요 스프링 보안 인터페이스 인 인스턴스 를 생성하는 데 사용된다 .
// AuthenticationManagerBuilder메모리 내 인증, LDAP 인증, JDBC 인증을 작성하거나 사용자 정의 인증 제공자를 추가하는 데 사용할 수 있습니다 .
// 이 예에서는 customUserDetailsService와 passwordEncoder를 제공하여 AuthenticationManager를 작성했습니다.
// 이 구성 AuthenticationManager을 사용 하여 로그인 API에서 사용자를 인증합니다.
    @Bean(BeanIds.AUTHENTICATION_MANAGER)
    @Override
    public AuthenticationManager authenticationManagerBean() throws Exception {
        return super.authenticationManagerBean();
    }
    
    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.cors().and().csrf().disable().exceptionHandling().authenticationEntryPoint(unauthorizedHandler).and()
                .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS).and().authorizeRequests()
                .antMatchers("/", "/favicon.ico", "/**/*.png", "/**/*.gif", "/**/*.svg", "/**/*.jpg", "/**/*.html",
                        "/**/*.css", "/**/*.js")
                .permitAll().antMatchers("/api/auth/**").permitAll()
                .antMatchers("/api/user/checkUsernameAvailability", "/api/user/checkEmailAvailability").permitAll()
                .antMatchers(HttpMethod.GET, "/api/polls/**", "/api/users/**").permitAll().anyRequest().authenticated();

        // Add our custom JWT security filter
        http.addFilterBefore(jwtAuthenticationFilter(), UsernamePasswordAuthenticationFilter.class);

    }

    // @Bean
    // public HttpSessionStrategy httpSessionStrategy() {
    //     return new HeaderHttpSessionStrategy();
    // }

    // @Bean
    // @Override
    // public UserDetailsService userDetailsService() {
    //     UserDetails user =
    //          User.withDefaultPasswordEncoder()
    //             .username("user")
    //             .password("password")
    //             .roles("USER")
    //             .build();

    //     return new InMemoryUserDetailsManager(user);
    // }

}