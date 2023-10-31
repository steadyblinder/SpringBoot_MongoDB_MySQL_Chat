package com.ctrenka.spring_mongodb_mysql_auth.Authenticaton;

import org.springframework.security.authentication.AbstractAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.CredentialsContainer;
import org.springframework.security.core.GrantedAuthority;

import javax.security.auth.Subject;
import java.util.Collection;
import java.util.Collections;

public class MyAuthentication extends AbstractAuthenticationToken {

    private final Authentication first;

    public MyAuthentication(Authentication first) {
        super(Collections.emptyList());
        this.first = first;
    }

    @Override
    public Object getCredentials() {
        return this.first.getCredentials();
    }

    @Override
    public Object getPrincipal() {
        return this.first.getPrincipal();
    }

    @Override
    public void eraseCredentials() {
        if(this.first instanceof CredentialsContainer){
            ((CredentialsContainer) this.first).eraseCredentials();
        }
    }

    @Override
    public boolean isAuthenticated() {
        return this.first.isAuthenticated();
    }

    public Authentication getFirst() {
        return this.first;
    }
}
