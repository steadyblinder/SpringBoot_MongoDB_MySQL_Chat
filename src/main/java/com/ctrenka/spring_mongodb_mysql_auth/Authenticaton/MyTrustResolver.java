package com.ctrenka.spring_mongodb_mysql_auth.Authenticaton;

import org.springframework.security.authentication.AuthenticationTrustResolver;
import org.springframework.security.authentication.AuthenticationTrustResolverImpl;
import org.springframework.security.core.Authentication;

public class MyTrustResolver implements AuthenticationTrustResolver {
    private final AuthenticationTrustResolver delegate = new AuthenticationTrustResolverImpl();

    @Override
    public boolean isAnonymous(Authentication authentication) {
        return this.delegate.isAnonymous(authentication) || authentication instanceof MyAuthentication;
    }

    @Override
    public boolean isRememberMe(Authentication authentication) {
        return this.delegate.isRememberMe(authentication);
    }
}
