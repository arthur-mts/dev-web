package com.ifpb.dev.web.atividade7.servlet;

import com.ifpb.dev.web.atividade7.banco.BancoDeDados;
import com.ifpb.dev.web.atividade7.banco.BancoDeDadosImp;
import com.ifpb.dev.web.atividade7.entidades.Bebida;
import com.ifpb.dev.web.atividade7.entidades.Tipo;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet(name = "BebidaServlet", value = "/bebida")
public class BebidaServlet extends HttpServlet {

    private final BancoDeDados banco = new BancoDeDadosImp();
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        var body = req.getParameterMap();
        var nome = body.get("nome")[0];
        var tipo = body.get("tipo")[0];
        var teor = body.get("teor")[0];
        var bebida = new Bebida(nome, Double.valueOf(teor), Tipo.valueOf(tipo.toUpperCase()));
        banco.salvar(bebida);

        resp.setStatus(HttpServletResponse.SC_CREATED);
        resp.sendRedirect(req.getContextPath() + "/listagem.jsp");
    }
}
