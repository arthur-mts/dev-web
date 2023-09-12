package com.ifpb.dev.web.atividade5;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;


@WebServlet("/questao3-servlet")
public class Questao3Servlet extends HttpServlet {

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        int temperature =
                Integer.parseInt(req.getParameterMap().getOrDefault("temperature", new String[]{"1"})[0]);

        String html = "<html>" +
                "<head> <meta charset=\"UTF-8\"></head>"+
                "<body>" +
                "<p>Temperatura em Fahrenheit: %.2f °F</p>".formatted((temperature * 1.8) + 32) +
                "</body>" +
                "</html>";
        resp.getWriter().println(html);
    }
}