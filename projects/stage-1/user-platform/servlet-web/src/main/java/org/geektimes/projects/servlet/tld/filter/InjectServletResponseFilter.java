package org.geektimes.projects.servlet.tld.filter;

import org.geektimes.projects.servlet.tld.servlet.MyGlobalHttpServletResponseHolder;

import javax.servlet.*;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class InjectServletResponseFilter  implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        if (servletResponse instanceof HttpServletResponse) {
            //注入全局响应
            System.out.println("inject global servlet response");
            MyGlobalHttpServletResponseHolder.setHttpServletResponse((HttpServletResponse) servletResponse);
        }


        filterChain.doFilter(servletRequest, servletResponse);
    }

    @Override
    public void destroy() {

    }
}
