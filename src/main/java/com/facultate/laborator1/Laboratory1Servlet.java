package com.facultate.laborator1;

import com.facultate.laborator1.compulsory.OrderedList;
import com.facultate.laborator1.homework.WordPermutations;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;

@WebServlet(name = "lab1servlet", value = "/lab1-servlet")
public class Laboratory1Servlet extends HttpServlet {

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("text/html");

        String word = request.getParameter("word");
        String size = request.getParameter("size");
        Enumeration<String> headerNames = request.getHeaderNames();

        PrintWriter out = response.getWriter();
        out.println("<html><body>"); // Start html

        if (word != null) {
            out.println("<div>Word to ordered list</div>");
            out.println(OrderedList.wordToOrderedList(word));

            if (size != null) {
                out.println(String.format("<div>Word permutations of length <%s></div>", size));
                out.println(WordPermutations.getPermutationsOfLength(word, "", Integer.parseInt(size)));
            } else {
                out.println("<div>Word permutations of all lengths since size is not specified</div>");
                out.println(WordPermutations.getAllPermutations(word, ""));
            }
        } else {
            out.println("<div>No word received</div>");
        }


        // Print all headers, will be useful for extracting user agent for bonus
        if (headerNames != null) {
            while (headerNames.hasMoreElements()) {
                String headerName = headerNames.nextElement();
                out.println("Header " + headerName + ":" + request.getHeader(headerName) + "<br>");
            }
        }

        out.println("</body></html>"); // End html
    }

    public void destroy() {
    }
}