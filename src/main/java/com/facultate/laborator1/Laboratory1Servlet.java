package com.facultate.laborator1;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.logging.FileHandler;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;

import static com.facultate.laborator1.bonus.RequestUtils.getIpFromRequest;
import static com.facultate.laborator1.bonus.RequestUtils.getParametersFromRequest;

@WebServlet(name = "lab1servlet", value = "/lab1-servlet")
public class Laboratory1Servlet extends HttpServlet {
    private Logger logger = Logger.getLogger("MyLog");
    FileHandler fileHandler;

    public void init() {
        try {
            fileHandler = new FileHandler("/Users/razcro/Desktop/Facultate/Java/Laboratory1/logs/requests_logs.log", true);
        } catch (IOException e) {
            e.printStackTrace();
        }
        logger.addHandler(fileHandler);
        SimpleFormatter formatter = new SimpleFormatter();
        fileHandler.setFormatter(formatter);
    }


    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {

        String clientIp = getIpFromRequest(request);
        String userAgent = request.getHeader("user-agent");

        logger.info(String.format("Request with %s method, from IP %s with the user-agent %s, the language %s and the following parameters: %s",
                request.getMethod(), clientIp, userAgent, request.getLocale(), getParametersFromRequest(request)));

        response.setContentType("text/html");

        String word = request.getParameter("word");
        String size = request.getParameter("size") != null ? request.getParameter("size") : "0";

        WordReturner wordReturner = new WordReturner(response);
        if (userAgent.contains("python-requests")) {
            wordReturner.returnText(word, size);
        } else {
            wordReturner.returnHTML(word, size);
        }

    }

    public void destroy() {
    }
}