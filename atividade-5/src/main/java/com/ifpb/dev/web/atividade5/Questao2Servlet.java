package com.ifpb.dev.web.atividade5;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.Map;


@WebServlet("/questao2-servlet")
public class Questao2Servlet extends HttpServlet {

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        int number =
                Integer.parseInt(req.getParameterMap().getOrDefault("number", new String[]{"1"})[0]);

        StringBuilder html = new StringBuilder();
        html.append("<html>");
        html.append("<head> <meta charset=\"UTF-8\"></head>");
        html.append("<body>");
        html.append("<h1>Tabuada do numero %d".formatted(number));
        html.append("<ul>");
        for (int i = 1; i < 10; i++) {
            html.append("<li>%d * %d = %d</li>".formatted(i, number, i * number));
        }
        html.append("</ul>");
        html.append("</body>");
        html.append("</html>");
        resp.getWriter().println(html);
    }
}