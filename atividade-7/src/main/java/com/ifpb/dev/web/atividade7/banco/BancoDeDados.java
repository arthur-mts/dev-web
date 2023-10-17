package com.ifpb.dev.web.atividade7.banco;

import com.ifpb.dev.web.atividade7.entidades.Bebida;

import java.util.List;

public interface BancoDeDados {
    void salvar(Bebida b);

    void atualizar(Bebida b);

    Bebida consultar(Integer id);

    boolean remover(Integer id);

    List<Bebida> listar(Ordernar ordernarPor);
}
