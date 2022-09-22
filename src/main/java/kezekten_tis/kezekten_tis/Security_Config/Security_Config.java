package kezekten_tis.kezekten_tis.Security_Config;

import kezekten_tis.kezekten_tis.Services.UserService;
import kezekten_tis.kezekten_tis.Services.impl.UserServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true ,proxyTargetClass = true,securedEnabled = true)
public class Security_Config {

    @Bean
    @Primary
    public UserService usersservice(){
     return new UserServiceImpl();
    }

    @Bean
    public PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity security) throws Exception{

    AuthenticationManagerBuilder authenticationManagerBuilder=security.getSharedObject(AuthenticationManagerBuilder.class);
        authenticationManagerBuilder.userDetailsService(usersservice()).passwordEncoder(passwordEncoder());
        security.exceptionHandling().accessDeniedPage("/forbidden");
        security.authorizeRequests().antMatchers("/css/**", "/js/**").permitAll();

        security.formLogin()
                .loginPage("/signup").permitAll()//"form that used to send email and password"
                .loginProcessingUrl("/auth").permitAll()//url which receive email and password
                .usernameParameter("user_email")//input of signin
                .passwordParameter("user_password") //input of signin
                .defaultSuccessUrl("/mainpage")//send after success authorisation
                .failureUrl("/signup?error")// send after fail authorisation

                .permitAll();

        security.logout()
                .logoutSuccessUrl("/signup")
                .logoutUrl("/logout");

        security.csrf().disable();
        return security.build();

    }



}
