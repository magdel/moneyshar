package ru.moneyshar.site.config;

import org.springframework.context.ApplicationListener;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.event.AuthenticationSuccessEvent;
import org.springframework.security.oauth2.provider.authentication.OAuth2AuthenticationDetails;
import org.springframework.social.facebook.api.Facebook;
import org.springframework.social.facebook.api.impl.FacebookTemplate;
import ru.moneyshar.site.auth.UserAuthenticationProvider;

/**
 * Created with IntelliJ IDEA.
 * User: rfk
 * Date: 16.12.14
 * Time: 3:31
 * To change this template use File | Settings | File Templates.
 */
@Configuration
public class UserAuthenticationConfiguration {

    @Bean(initMethod = "init")
    UserAuthenticationProvider userAuthenticationProvider() {
        return new UserAuthenticationProvider();
    }

    @Bean
    UserEventsProcessor authenticationEventProcessor() {
        return new UserEventsProcessor();
    }


    public class UserEventsProcessor implements ApplicationListener<AuthenticationSuccessEvent> {

        public UserEventsProcessor() {
        }

        public void onApplicationEvent(AuthenticationSuccessEvent event) {
            System.out.println("Authenticated " + event + " with details : " + event.getAuthentication());
            OAuth2AuthenticationDetails details = (OAuth2AuthenticationDetails) event.getAuthentication().getDetails();
            Facebook facebook = new FacebookTemplate(details.getTokenValue());
            String firstName = facebook.userOperations().getUserProfile().getFirstName();
            System.out.println("firstName: " + firstName);

            // Do more processing as per application logic
        }
    }
}
