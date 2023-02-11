package be.yonicon.template.config;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

// squid:S1118 : constructor needed for Spring Configuration
// squid:S4604 : EnableAutoConfiguration needed for enabling spring security
@SuppressWarnings({"squid:S4604", "squid:S1118"})
@Configuration
public class SecurityConfig {

    @Configuration
    @EnableAutoConfiguration
    @ConditionalOnProperty(prefix = "be.yonicon.template.infra.security", name = "enabled", havingValue = "false")
    protected static class DefaultWebSecurityConfig extends WebSecurityConfigurerAdapter {

        @Override
        public void configure(WebSecurity web) {
            web.ignoring().antMatchers("/**");
        }

        @Override
        protected void configure(HttpSecurity http) throws Exception {
            http.authorizeRequests().anyRequest().permitAll();
        }
    }

    @EnableWebSecurity
    @EnableAutoConfiguration
    @ConditionalOnProperty(prefix = "be.yonicon.template.infra.security", name = "enabled")
    protected static class SsoConfig extends WebSecurityConfigurerAdapter {

        @Override
        public void configure(WebSecurity web) {
            web.ignoring().antMatchers("/actuator/**");
        }

        @Override
        protected void configure(HttpSecurity http) throws Exception {
            // TODO implement security if required.
            http.csrf().disable().authorizeRequests().anyRequest().authenticated();
        }
    }
}