package org.geektimes.projects.servlet.tld.servlet;

import javax.servlet.http.HttpServletResponse;

public class MyGlobalHttpServletResponseHolder {
    private static final ThreadLocal<HttpServletResponse> responseHolder = new ThreadLocal<>();

    public static void setHttpServletResponse(HttpServletResponse response) {
        responseHolder.set(response);
    }

    public static HttpServletResponse getHttpServletResponse() {
        return responseHolder.get();
    }

    public static void reset() {
        responseHolder.remove();
    }

}
