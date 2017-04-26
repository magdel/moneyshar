package ru.moneyshar.site.web.auth;

import org.springframework.security.core.Authentication;

public interface AuthenticationFacade {
    Authentication getAuthentication();

    // SiteUser getUser();

    String getUserId();
}
