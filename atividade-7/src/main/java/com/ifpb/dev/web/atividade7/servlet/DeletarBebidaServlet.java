package com.ifpb.dev.web.atividade7.servlet;

import com.ifpb.dev.web.atividade7.banco.BancoDeDados;
import com.ifpb.dev.web.atividade7.banco.BancoDeDadosImp;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet(name = "DeletarBebidaServlet", value = "/bebida/*")
public class DeletarBebidaServlet extends HttpServlet {
    private final BancoDeDados bd = new BancoDeDadosImp();

    private String extrairId(HttpServletRequest req) {
        var pathFields = req.getPathInfo().split("/");
        if (pathFields.length < 2) {
            return null;
        }
        return  pathFields[1];
    }

    @Override
    protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        var id = this.extrairId(req);
        if (id == null) {
            resp.setStatus(HttpServletResponse.SC_BAD_REQUEST);
            resp.setContentType("application/txt");
            resp.getWriter().print("Eh preciso enviar o ID. Exemplo: /bebida/12");
            return;
        }
        bd.remover(Integer.parseInt(id));
        resp.setStatus(HttpServletResponse.SC_OK);
    }
}
