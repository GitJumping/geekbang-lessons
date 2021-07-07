package org.geektimes.projects.servlet.tld.tags;

import org.geektimes.projects.servlet.tld.servlet.MyGlobalHttpServletResponseHolder;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.SimpleTagSupport;
import java.io.IOException;

public class MyCommonResponseHeadersTag extends SimpleTagSupport {
    private String header;
    private String value;

    public String getHeader() {
        return header;
    }

    public void setHeader(String header) {
        this.header = header;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    @Override
    public void doTag() throws JspException, IOException {
        HttpServletResponse response = MyGlobalHttpServletResponseHolder.getHttpServletResponse();
        if (response != null && isValid() )
            response.setHeader(header, value);

        super.doTag();
    }

    /**
     * 校验响应头是否合法
     * @return 是否合法
     */
    private boolean isValid() {
        return (header != null && header.length() > 0) && (value != null && value.length() > 0);
    }
}
