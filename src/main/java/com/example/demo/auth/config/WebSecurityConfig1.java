package com.example.demo.auth.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;

import javax.sql.DataSource;

/*
Uncomment the annotations below if you wish to use this security configuration file and comment these out in WebSecurityConfig2
*/
//@Configuration
//@EnableWebSecurity
public class WebSecurityConfig1 extends WebSecurityConfigurerAdapter {

    private final DataSource dataSource;

    public WebSecurityConfig1(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    @Bean
    public BCryptPasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public AuthenticationSuccessHandler authSuccessHandler(){
        return new AuthSuccessHandler();
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        /*
            These pages can be public and not need auth
        */
        http.authorizeRequests().antMatchers("/", "/login", "/register", "/registration").permitAll();

        /*
            Use built in login form
        */
        http.authorizeRequests().anyRequest().authenticated().and().formLogin()
                .defaultSuccessUrl("/userArea");

    }


    /*

    Test this by adding a new user directly to your database in MySQL workbench. To do this:

    Add a new row to the user table using a username of your choice (e.g., myuser),
    a password of your choice (e.g., mypassword) that is hashed using bcrypt (go to https://www.browserling.com/tools/bcrypt which will produce something like $2a$10$/MedkzYBTlhAa06V1I7ziOIpG8zq8tFvNgUymA/RgEkQ5Dp8EQuEu),
    and 1 as the value of enabled.

    Add a new row to the authorities table where username is the same as what you chose for the above and the authority is ROLE_USER.

    After you have done this, try to use these credentials to log into the system.

    */
    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
        auth.jdbcAuthentication()
                .passwordEncoder(passwordEncoder())
                .dataSource(dataSource);
                /*
                Optional customised queries, e.g. if different tables are used
                 */
                /*.usersByUsernameQuery("select username, password, enabled "
                + "from users "
                + "where username =?"
                )
                .authoritiesByUsernameQuery("select username, authority "
                + "from authorities "
                + "where username = ?"
                );*/
    }



}