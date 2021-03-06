package com.restful.api.auth.filter;

import com.restful.api.auth.service.TokenAuthenticationService;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.filter.GenericFilterBean;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

/**
 * @author Damiano Alves on 23/02/19
 * damiano.alves@gmail.com
 */
public class AuthenticationFilter extends GenericFilterBean {

    public void doFilter(ServletRequest request,
                         ServletResponse response,
                         FilterChain filterChain
    ) throws IOException, ServletException {

        Authentication authentication = TokenAuthenticationService.getAuthentication((HttpServletRequest) request);

        SecurityContextHolder.getContext().setAuthentication(authentication);

        filterChain.doFilter(request, response);
    }

}