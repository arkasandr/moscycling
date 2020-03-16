package ru.arkaleks.moscycling.config;

import org.springframework.stereotype.Component;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.stream.Collectors;

@Component
public class AjaxLoginFilter implements Filter {

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {

            HttpServletRequest httpRequest = (HttpServletRequest) request;
            HttpServletResponse httpResponse= (HttpServletResponse) response;

//        ObjectMapper mapper = new ObjectMapper();
//        User user = mapper.readValues(httpRequest);
        System.out.println(httpRequest.getReader().lines().collect(Collectors.joining()));
            System.out.println("Filter: URL called: "+httpRequest.getRequestURL().toString());
            System.out.println(httpRequest.getParameter("password"));

            chain.doFilter(request, response);
    }
}
