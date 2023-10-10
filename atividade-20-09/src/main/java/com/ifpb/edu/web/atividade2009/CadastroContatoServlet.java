package com.ifpb.edu.web.atividade2009;


import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet(name = "cadastro-contato", value = "/cadastro")
public class CadastroContatoServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        var body = req.getParameterMap();
        ListaTelefonica.cadastrarContato(body.get("nome")[0], body.get("numero")[0], body.get("email")[0]);
        resp.sendRedirect("index.jsp");
    }
}
