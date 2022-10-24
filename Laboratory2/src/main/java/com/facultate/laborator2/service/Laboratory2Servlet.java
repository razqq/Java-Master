package com.facultate.laborator2.service;

import com.facultate.laborator2.activity.WordReturner;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.Objects;
import java.util.Set;

import static com.facultate.laborator2.activity.RequestUtils.getIpFromRequest;

@WebServlet(name = "Controller", value = "/lab2-servlet")
public class Laboratory2Servlet extends HttpServlet {

    private void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String clientIp = getIpFromRequest(request);
        String userAgent = request.getHeader("user-agent");

//        logger.info(String.format("Request with %s method, from IP %s with the user-agent %s, the language %s and the following parameters: %s",
//                request.getMethod(), clientIp, userAgent, request.getLocale(), getParametersFromRequest(request)));

        response.setContentType("text/html");

        String word = request.getParameter("word");
        String size = request.getParameter("size") != null ? (String) request.getAttribute("size") : "0";
        String category = request.getParameter("category");

        WordReturner wordReturner = new WordReturner(response);
        Set<String> returnedWords = wordReturner.returnText(word, size);
        request.setAttribute("wordsReturned", returnedWords);

        if (Objects.equals(request.getParameter("circlesGuessed"), request.getParameter("captchaCircleCount"))) {
            request.getRequestDispatcher("/result.jsp").forward(request, response);
        } else {
            request.getRequestDispatcher("/error.jsp").forward(request, response);
        }
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        processRequest(request, response);
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        processRequest(request, response);
    }

    public void destroy() {
    }
}