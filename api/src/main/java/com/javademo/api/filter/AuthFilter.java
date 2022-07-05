package com.javademo.api.filter;


import com.google.gson.Gson;
import com.javademo.common.api.Result;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.charset.StandardCharsets;

@Order(-1)
@WebFilter(urlPatterns = {"/api/*"})
public class AuthFilter implements Filter {
    private static final String[] NOT_FILTER_URL = new String[]{""};
    private final static Logger LOG = LoggerFactory.getLogger(AuthFilter.class);

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws ServletException, IOException {
        HttpServletRequest httpServletRequest = (HttpServletRequest) request;
        HttpServletResponse httpServletResponse = (HttpServletResponse) response;
        String url = httpServletRequest.getRequestURI();
        LOG.info("-------doFilter--------");
        //不需要认证
        if (StringUtils.equalsAny(url, NOT_FILTER_URL)) {
            LOG.info("-------url not filter{}-------", url);
            chain.doFilter(request, response);
        }
        //需要认证
        try {
            httpServletRequest.getAuthType();
            String authorization = httpServletRequest.getHeader("Authorization");
            String token = StringUtils.removeStart(authorization,"Bearer ");
            if (StringUtils.equals(token, "token")) {
                LOG.info("-------url authorization validate success{}-------", url);
                chain.doFilter(request, response);
            }else authFail(httpServletResponse);
        } catch (Exception e) {
            LOG.error("authorization validate exception", e);
            authFail(httpServletResponse);
        }
    }

    public static void authFail(HttpServletResponse httpServletResponse) throws IOException {
        httpServletResponse.setCharacterEncoding(StandardCharsets.UTF_8.name());
        httpServletResponse.setStatus(HttpStatus.UNAUTHORIZED.value());
        httpServletResponse.setHeader(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE);
        Result<Object> error = Result.error(HttpStatus.UNAUTHORIZED.value(), HttpStatus.UNAUTHORIZED.getReasonPhrase());
        Gson gson = new Gson();
        PrintWriter writer = httpServletResponse.getWriter();
        writer.write(gson.toJson(error));
        writer.flush();
    }
}
