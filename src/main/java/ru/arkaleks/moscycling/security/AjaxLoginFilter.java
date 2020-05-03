package ru.arkaleks.moscycling.security;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.AbstractAuthenticationProcessingFilter;
import ru.arkaleks.moscycling.model.User;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.stream.Collectors;

public class AjaxLoginFilter extends AbstractAuthenticationProcessingFilter {

    public AjaxLoginFilter(String defaultFilterProcessesUrl) {
        super(defaultFilterProcessesUrl);
    }

    @Override
    public Authentication attemptAuthentication(HttpServletRequest httpRequest, HttpServletResponse httpresponse) throws AuthenticationException, IOException {
        ObjectMapper mapper = new ObjectMapper();
        User user = mapper.readValue(httpRequest.getReader().lines().collect(Collectors.joining()), User.class);
        Authentication auth = new UsernamePasswordAuthenticationToken(user.getUsername(), user.getPassword());
        SecurityContextHolder.getContext().setAuthentication(auth);
        System.out.println("Username is " + auth.getPrincipal());
        System.out.println("password is " + auth.getCredentials());
        System.out.println("Filter: URL called: " + httpRequest.getRequestURL().toString());
        return getAuthenticationManager().authenticate(auth);
    }
}
