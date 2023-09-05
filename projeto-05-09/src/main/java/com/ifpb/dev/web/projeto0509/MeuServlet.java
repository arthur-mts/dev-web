package com.ifpb.dev.web.projeto0509;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

// Uma classe JAVA que sabe trabalhar com HTTP
// TODO: exportar esse projeto
@WebServlet("/primeiro-servlet")
public class MeuServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        resp.getWriter().println("<html><h1>EITA</h1></html>");
    }
}
