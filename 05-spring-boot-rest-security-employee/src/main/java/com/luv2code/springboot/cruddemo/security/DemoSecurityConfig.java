package com.luv2code.springboot.cruddemo.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.provisioning.JdbcUserDetailsManager;
import org.springframework.security.provisioning.UserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

import javax.sql.DataSource;

@Configuration
public class DemoSecurityConfig {

    /*
    ! create Authorization by using InMemory
    @Bean
    public InMemoryUserDetailsManager userDetailsManager(){
        UserDetails jhon = User.builder()
                .username("jhon")
                .password("{noop}test123")
                .roles("EMPLOYEE")
                .build();

        UserDetails mary = User.builder()
                .username("mary")
                .password("{noop}test123")
                .roles("EMPLOYEE", "MANAGER")
                .build();

        UserDetails susan = User.builder()
                .username("susan")
                .password("{noop}test123")
                .roles("EMPLOYEE", "MANAGER", "ADMIN")
                .build();

       return new InMemoryUserDetailsManager(jhon, mary, susan);
    }
*/
    // ! Authorization By using JDBC
    @Bean
    public UserDetailsManager userDetailsManager(DataSource dataSource) {
        /*
        * inject DataSource Auto-configured by Springboot
        * we don't have to assign the table or the database, the spring will automatically detect the User table and we just use this
        * */

        //? Tell Spring Security to use JDBC authentication will our data source

        // refactor:  Introduce Variable
        JdbcUserDetailsManager jdbcUserDetailsManager = new JdbcUserDetailsManager(dataSource);

        //!  define query to retrieve a user by username
        jdbcUserDetailsManager.setUsersByUsernameQuery("select user_id, pw, active from members where user_id=?");
        // ? Question mark "?" parameter value will be the user name from login
        /*
        * when there is something we don't know what happening, example by default, error caused by typo of query is not coming up in terminal. so we have to assign debug in application properties. when we hit endpoint, the debug will come up in terminal
        * */

        //! define query to retrieve the authorities/roles by username
        jdbcUserDetailsManager.setAuthoritiesByUsernameQuery("select user_id, role from roles where user_id=?");


        return jdbcUserDetailsManager;
    }
    

    // Restricted Access to Roles
    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http.authorizeRequests(configurer ->
                configurer
                        .requestMatchers(HttpMethod.GET, "/api/employees").hasRole("EMPLOYEE")
                        .requestMatchers(HttpMethod.GET, "/api/employees/**").hasRole("EMPLOYEE")
                        .requestMatchers(HttpMethod.POST, "/api/employees").hasRole("MANAGER")
                        .requestMatchers(HttpMethod.PUT, "/api/employees/**").hasRole("MANAGER")
                        .requestMatchers(HttpMethod.DELETE, "/api/employees/**").hasRole("ADMIN")
        );
        // use HTTP Basic Authentication
        // ? Tell the security that we're using basic authentication
        http.httpBasic(Customizer.withDefaults());

        // disable Cros Site Request Forgery (CSRF)
        // in general, note required for stateless REST APIs that user POST, PUT, DELETE, and/or PATCH
        // when i comment this, i cannot access post even I use admin account
        http.csrf(csrf -> csrf.disable());
        return http.build();
    }
}

/*
* since we define our user here,
* Spring boot will not use the user/pass from the application.properties
* InMemoryUserDetailsManager don't store in database yet
! Use postman basic auth in authorization tab
? 403 ERROR - PUT
* error occure if using spring data REST, so we have to change the code that using spring data rest for put requests the ID is on the URL
* /api/employees/{employeeId}
* as a result, need to modify the security configuration
* */