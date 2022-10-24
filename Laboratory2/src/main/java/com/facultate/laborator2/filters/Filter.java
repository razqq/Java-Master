package com.facultate.laborator2.filters;


import com.facultate.laborator2.wrappers.wrapper.SimpleResponseWrapper;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.HttpFilter;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;

@WebFilter(filterName = "ResponseDecorator", urlPatterns = {"/lab2-servlet"})
public class Filter extends HttpFilter {

    private static final String PRELUDE = "<h3>Prelude</h3>";
    private static final String CODA = "<h3>Coda</h3>";

    @Override
    public void doFilter(ServletRequest req, ServletResponse res, FilterChain chain) throws IOException, ServletException {

        SimpleResponseWrapper wrapper
                = new SimpleResponseWrapper((HttpServletResponse) res);

        chain.doFilter(req, wrapper);
        //Get the dynamically generated content from the decorator
        String content = wrapper.toString();
        //Send the modified content using the original response
        PrintWriter out = res.getWriter();
        out.write(PRELUDE + content + CODA);

    }

    @Override
    public void init() throws ServletException {
        super.init();
    }
}
