package com.facultate.laborator2.service;

import com.facultate.laborator2.activity.CaptchaGenerator;
import com.facultate.laborator2.models.CaptchaDetails;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.Objects;

import static com.facultate.laborator2.listeners.SessionListener.category;

@WebServlet(name = "ControllerCaptcha", value = "/captcha")
public class LaboratoryCaptchaServlet extends HttpServlet {

    private void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.addCookie(new Cookie("category",category));
        CaptchaDetails captchaDetails = CaptchaGenerator.getCaptcha();
        request.setAttribute("captchaImage", captchaDetails.getImageBase64());
        request.setAttribute("captchaCircleCount", captchaDetails.getCirclesCount());
        String word = request.getParameter("word");
        String size = request.getParameter("size") != null ? request.getParameter("size") : "0";
        String category = request.getParameter("category");
        System.out.println(word);
        System.out.println(size);
        response.setContentType("text/html");
        String redirectUrl = "/captcha.jsp?";
        if (!Objects.equals(word, "")){
            redirectUrl += "word=" + word + "&";
        }
        if (!Objects.equals(size, "")){
            redirectUrl += "size=" + size + "&";
        }
        if (!Objects.equals(category, "")){
            redirectUrl += "category=" + category + "&";
        }
        redirectUrl += "captchaCircleCount=" + category;
        request.getRequestDispatcher(redirectUrl).forward(request, response);
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