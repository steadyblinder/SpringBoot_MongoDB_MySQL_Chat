package com.ctrenka.spring_mongodb_mysql_auth.Authenticaton;

import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.security.web.authentication.SimpleUrlAuthenticationSuccessHandler;

import java.io.IOException;

public class MyAuthenticationHandler implements AuthenticationSuccessHandler, AuthenticationFailureHandler {
    private final AuthenticationSuccessHandler authenticationSuccessHandler;

    public MyAuthenticationHandler(String url) {
        SimpleUrlAuthenticationSuccessHandler handler = new SimpleUrlAuthenticationSuccessHandler(url);
        handler.setAlwaysUseDefaultTargetUrl(true);
        System.out.println("This is authentication handler....");
        this.authenticationSuccessHandler = handler;
    }

    @Override
    public void onAuthenticationFailure(HttpServletRequest request, HttpServletResponse response, AuthenticationException exception) throws IOException, ServletException {
        Authentication anonymous = new AnonymousAuthenticationToken("key", "AnonymousUser",
                AuthorityUtils.createAuthorityList("ROLE_ANONYMOUS"));


    }

    @Override
    public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication) throws IOException, ServletException {

    }

    private void saveMyAuthentication(ServletRequest request, ServletResponse response, Authentication authentication) throws IOException, ServletException{
        SecurityContextHolder.getContext().setAuthentication(authentication);

    }
}
