package com.h.jamil.api.common.netflix.eureka;

/**
 * Created by Krit Sudduen on 12/20/2016.
 */

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;
import org.springframework.context.annotation.Bean;

import javax.servlet.*;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


@EnableAutoConfiguration
@EnableEurekaServer
@SpringBootApplication
public class EurekaServer {

    public static void main(String[] args) {
        //Added NOSONAR for known issue with SB project
        //Refer to http://stackoverflow.com/questions/37071032/sonarqube-close-this-configurableapplicationcontext-in-spring-boot-project
        SpringApplication.run(EurekaServer.class, args); //NOSONAR
    }

    @Bean
    public Filter customHeaderFilter() {
        return new Filter() {
            @Override
            public void init(FilterConfig filterConfig) throws ServletException {

            }

            @Override
            public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
                final HttpServletResponse res = (HttpServletResponse) servletResponse;
                res.addHeader("X-Frame-Options", "SAMEORIGIN");

                filterChain.doFilter(servletRequest, servletResponse);
            }

            @Override
            public void destroy() {

            }
        };
    }
}
