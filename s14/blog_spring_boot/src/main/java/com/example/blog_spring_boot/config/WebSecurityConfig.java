package com.example.blog_spring_boot.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.thymeleaf.extras.springsecurity6.dialect.SpringSecurityDialect;


@Configuration
@EnableWebSecurity
public class WebSecurityConfig {
    @Autowired
    private CustomAuthFailureHandler customAuthFailureHandler;
    @Autowired
    private UserDetailsService userDetailsService;

//    SpringSecurityDialect là một thành phần tích hợp giữa Spring Security và Thymeleaf,
//    giúp bạn dễ dàng kiểm soát và hiển thị nội dung trong các template Thymeleaf dựa trên quyền hạn và trạng thái xác thực của người dùng.
//    Dưới đây là giải thích chi tiết về mục đích và cách sử dụng SpringSecurityDialect trong ứng dụng Spring Boot của bạn.
    @Bean
    public SpringSecurityDialect springSecurityDialect() {
        return new SpringSecurityDialect();
    }

    @Bean
    public BCryptPasswordEncoder passwordEncoder() {
        BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
        return bCryptPasswordEncoder;
    }
    @Bean
    public AuthenticationManager authenticationManager(AuthenticationConfiguration config) throws Exception {
        // dùng AuthenticationConfiguration thay vì HttpSecurity
        return config.getAuthenticationManager();
    }


    // xác thực
    @Bean
    public AuthenticationProvider authenticationProvider() {
        DaoAuthenticationProvider authenticationProvider = new DaoAuthenticationProvider();
        authenticationProvider.setUserDetailsService(userDetailsService);
        authenticationProvider.setPasswordEncoder(passwordEncoder());
        return authenticationProvider;
    }

//    @Bean
//    public AuthenticationProvider authenticationProvider() {
//        DaoAuthenticationProvider authenticationProvider = new DaoAuthenticationProvider();
//        authenticationProvider.setUserDetailsService(userDetailsService(passwordEncoder()));
//        authenticationProvider.setPasswordEncoder(passwordEncoder());
//        return authenticationProvider;
//    }
//
//    @Bean
//    public UserDetailsService userDetailsService(PasswordEncoder encoder) {
//        UserDetails admin = User.withUsername("admin")
//                .password(encoder.encode("123"))
//                .roles("ADMIN")
//                .build();
//        UserDetails user = User.withUsername("user")
//                .password(encoder.encode("123"))
//                .roles("USER")
//                .build();
//        return new InMemoryUserDetailsManager(admin, user);
//    }

    // phân quyền
    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
//         cấu hình có thể logout
        http.csrf(AbstractHttpConfigurer::disable);
        // tạo token cho method post
//        http.csrf(Customizer.withDefaults());
//        http.csrf((csrf) -> csrf
//                        .csrfTokenRepository(CookieCsrfTokenRepository.withHttpOnlyFalse())
//                );
        http.authorizeHttpRequests(auth -> auth
                // các đường dẫn không yêu cầu login
                .requestMatchers("/", "/home", "/blog", "/blogs/**", "/login", "/logout","/register", "/logoutSuccessful", "/403").permitAll()
                // tạo bài viết: chỉ USER
                .requestMatchers("/blog/create").hasRole("USER")
                // admin
                .requestMatchers("/admin").hasRole("ADMIN")
                // user & admin: xóa, user info
                .requestMatchers("/userInfo", "/blog/delete").hasAnyRole("USER", "ADMIN")
                // các request khác phải login
                .anyRequest().authenticated()
        );


        // cấu hình form login
        http.formLogin(form -> form
                .loginPage("/login")
                .loginProcessingUrl("/process-login") // đường dẫn trùng với url form login
                .defaultSuccessUrl("/home")
                .failureUrl("/login?error")
                .failureHandler(customAuthFailureHandler)
                .usernameParameter("username")//trùng với tên trong form đăng nhập
                .passwordParameter("password")// trung với tên trong form đăng nhập
        );
        http.logout(form -> form
                .logoutUrl("/logout")            // URL logout
                .logoutSuccessUrl("/home")       // 🔹 redirect về trang home
                .invalidateHttpSession(true)     // xóa session cũ
                .deleteCookies("JSESSIONID")     // xóa cookie session
        );


        // cấu hình trả về trang 403 khi không có quyền (role) truy cập
        http.exceptionHandling(ex -> ex.accessDeniedPage("/403"));
        return http.build();

    }

    // Cấu hình vùng nhớ lưu trạng thái đăng nhập trên bộ nhớ của máy tính người dùng
//    @Bean
//    public PersistentTokenRepository persistentTokenRepository() {
//        InMemoryTokenRepositoryImpl memory = new InMemoryTokenRepositoryImpl();
//        return memory;
//    }

}