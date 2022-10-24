package com.facultate.laborator2.listeners;

import jakarta.servlet.annotation.WebListener;
import jakarta.servlet.http.HttpSessionEvent;
import jakarta.servlet.http.HttpSessionListener;


@WebListener()
public class SessionListener implements HttpSessionListener {
    public static String category = "default";

    @Override
    public void sessionDestroyed(HttpSessionEvent se) {
        category = se.getSession().getServletContext().getInitParameter("category");
    }
}
