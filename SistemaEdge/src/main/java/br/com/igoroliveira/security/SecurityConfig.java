package br.com.igoroliveira.security;

import jdk.internal.dynalink.support.NameCodec;
import org.bouncycastle.crypto.generators.BCrypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)  // enables @Preauthorize annotations
public class SecurityConfig extends WebSecurityConfigurerAdapter {


    @Bean
    public PasswordEncoder getPasswordEncoder(){
        return new BCryptPasswordEncoder();
    }

    @Autowired
    private PasswordEncoder passwordEncoder;

    // makes sure that users can only access APIs if they are authenticated
    @Override
    protected void configure(final HttpSecurity http) throws Exception {
        http
                .authorizeRequests()
                .anyRequest().authenticated()
                .and().httpBasic();
    }


    /* Provides test user to access the resources.
     * In production, this is not allowed
     */
    @Bean
    @Override
    public UserDetailsService userDetailsService() {
        UserDetails user =
                User
                    .withUsername("999.999.999-99")
                    .password(passwordEncoder.encode("secretpassword"))
                    .authorities("FINANCIAL_EVENTS_READ","SCORE_READ")
                    .build();

        return new InMemoryUserDetailsManager(user);
    }

}
