package com.facultate.laborator1.bonus;

import jakarta.servlet.http.HttpServletRequest;

import java.util.Enumeration;

public class RequestUtils {
    public static String getIpFromRequest(HttpServletRequest request) {
        String ipAddress = request.getHeader("X-FORWARDED-FOR");
        if (ipAddress == null) {
            ipAddress = request.getRemoteAddr();
        }
        return ipAddress.contains(",") ? ipAddress.split(",")[0] : ipAddress;
    }

    public static String getParametersFromRequest(HttpServletRequest request) {
        Enumeration<String> parameterNames = request.getParameterNames();
        StringBuilder parameters = new StringBuilder("[");
        while (parameterNames.hasMoreElements()) {
            String parameterName = parameterNames.nextElement();
            String parameterValue = request.getParameter(parameterName);
            parameters.append("\n").append(parameterName).append(" : ").append(parameterValue);
        }
        parameters.append("]");
        return parameters.toString();
    }
}
