package com.ifpb.dev.web.atividade7.servlet;

import com.ifpb.dev.web.atividade7.banco.BancoDeDados;
import com.ifpb.dev.web.atividade7.banco.BancoDeDadosImp;
import com.ifpb.dev.web.atividade7.entidades.Bebida;
import com.ifpb.dev.web.atividade7.entidades.Tipo;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet(name = "AtualizarBebidaServlet", value = "/bebida/atualizar")
public class AtualizarBebidaServlet extends HttpServlet {
    private final BancoDeDados bd = new BancoDeDadosImp();

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        var novaBebida = new Bebida(
                req.getParameter("nome"),
                Integer.parseInt(req.getParameter("id")),
                Double.parseDouble(req.getParameter("teor")),
                Tipo.valueOf(req.getParameter("tipo").toUpperCase())
        );

        bd.atualizar(novaBebida);

        resp.setStatus(HttpServletResponse.SC_OK);
        resp.sendRedirect(req.getContextPath() + "/listagem.jsp");
    }
}
