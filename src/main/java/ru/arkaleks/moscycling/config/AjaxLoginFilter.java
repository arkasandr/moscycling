package ru.arkaleks.moscycling.config;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import ru.arkaleks.moscycling.model.User;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.stream.Collectors;

@Component
public class AjaxLoginFilter implements Filter {

    private AuthenticationManager authenticationManager;

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {

            HttpServletRequest httpRequest = (HttpServletRequest) request;
            HttpServletResponse httpResponse= (HttpServletResponse) response;
            if(httpRequest.getRequestURL().toString().endsWith("/login")) {
                ObjectMapper mapper = new ObjectMapper();
                User user = mapper.readValue(httpRequest.getReader().lines().collect(Collectors.joining()), User.class);
                Authentication auth = new UsernamePasswordAuthenticationToken(user.getUsername(), user.getPassword());
               // Authentication result = authenticationManager.authenticate(auth);
                System.out.println("Username is " + auth.getPrincipal());
                System.out.println("password is " + auth.getCredentials());
                SecurityContextHolder.getContext().setAuthentication(auth);
                System.out.println("Filter: URL called: " + httpRequest.getRequestURL().toString());
                System.out.println(user.getPassword());
                System.out.println(user.getUserRole());

                chain.doFilter(request, response);
            } else {
                chain.doFilter(request, response);
            }
    }
}
