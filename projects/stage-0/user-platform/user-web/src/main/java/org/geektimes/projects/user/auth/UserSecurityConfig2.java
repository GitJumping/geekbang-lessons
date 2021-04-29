package org.geektimes.projects.user.auth;

import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.annotation.web.configurers.ExceptionHandlingConfigurer;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.security.web.FilterChainProxy;
import org.springframework.security.web.WebAttributes;
import org.springframework.security.web.access.AccessDeniedHandler;
import org.springframework.security.web.access.AccessDeniedHandlerImpl;
import org.springframework.security.web.access.ExceptionTranslationFilter;
import org.springframework.security.web.authentication.LoginUrlAuthenticationEntryPoint;

import javax.naming.AuthenticationException;
import javax.servlet.FilterChain;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.nio.charset.Charset;

@SuppressWarnings("JavadocReference")
@Configuration
@Order(102)
public class UserSecurityConfig2  extends WebSecurityConfigurerAdapter {
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.inMemoryAuthentication().withUser("user").password("{noop}user").roles("USER").authorities("USER");
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        // 不指定path,本安全过滤链会匹配所有请求。
        http.authorizeRequests()
                .antMatchers("/user").permitAll();// 首页放行
    }

    /**
     * @see AccessDeniedHandlerImpl#handle(HttpServletRequest, HttpServletResponse, AccessDeniedException)
     */
    private static void accessDeniedHandle(HttpServletRequest request, HttpServletResponse response, AccessDeniedException accessDeniedException) throws IOException {
        request.setAttribute(WebAttributes.ACCESS_DENIED_403, accessDeniedException);
        response.setStatus(HttpStatus.FORBIDDEN.value());
        response.setCharacterEncoding(Charset.defaultCharset().displayName());// 解决中文乱码
        response.addHeader("Content-Type", MediaType.TEXT_HTML_VALUE);
        response.getWriter().write("你的权限不够");
    }
}
