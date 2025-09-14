package com.example.spring_datadog_demo.configs;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.slf4j.MDC;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;
import java.util.UUID;

@Component
public class MDCLoggingFilter extends OncePerRequestFilter {

    @Override
    protected void doFilterInternal(HttpServletRequest request,
                                    HttpServletResponse response,
                                    FilterChain filterChain)
            throws ServletException, IOException {

        try {
            // Request ID
            String requestId = UUID.randomUUID().toString();
            MDC.put("requestId", requestId);

            // IP do cliente
            String clientIp = getClientIp(request);
            MDC.put("clientIp", clientIp);

            // User-Agent
            String userAgent = request.getHeader("User-Agent");
            if (userAgent != null) {
                MDC.put("userAgent", userAgent);
            }

            // Usuário autenticado (Spring Security)
            // Authentication auth = SecurityContextHolder.getContext().getAuthentication();
            // if (auth != null && auth.isAuthenticated() && !"anonymousUser".equals(auth.getPrincipal())) {
            //     MDC.put("username", auth.getName());
            // }

            // Incluir requestId na resposta (útil para front ou logs cruzados)
            response.setHeader("X-Request-ID", requestId);

            // Continua a cadeia de filtros
            filterChain.doFilter(request, response);

        } finally {
            MDC.clear(); // Evita vazamento de contexto entre threads
        }
    }

    private String getClientIp(HttpServletRequest request) {
        String xfHeader = request.getHeader("X-Forwarded-For");
        return xfHeader != null ? xfHeader.split(",")[0] : request.getRemoteAddr();
    }
}