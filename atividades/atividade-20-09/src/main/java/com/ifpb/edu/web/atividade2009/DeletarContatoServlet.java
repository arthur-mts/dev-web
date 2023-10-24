package com.ifpb.edu.web.atividade2009;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet(name = "deletar-contato", value = "/deletar")
public class DeletarContatoServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        var id = Integer.parseInt(req.getParameter("id"));
        var removido = ListaTelefonica.removerContato(id);
        System.out.printf("ID = %d foi removido = %b", id, removido);
        resp.sendRedirect(req.getContextPath() + "/index.jsp");
    }
}
