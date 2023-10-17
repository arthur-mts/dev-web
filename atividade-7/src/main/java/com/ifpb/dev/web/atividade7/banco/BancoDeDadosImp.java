package com.ifpb.dev.web.atividade7.banco;

import com.ifpb.dev.web.atividade7.entidades.Bebida;
import com.ifpb.dev.web.atividade7.entidades.Tipo;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

public class BancoDeDadosImp implements BancoDeDados {
    private static final List<Bebida> bebidas = new ArrayList<>();

    static {
        bebidas.add(new Bebida("Cachaca", 12.3, Tipo.DESTILADO));
    }

    @Override
    public void salvar(Bebida b) {
        if (bebidas.stream().anyMatch((bebida -> bebida.id().equals(b.id())))) {
            throw new RuntimeException("Uma bebida com o ID " + b.id() + " já esta cadastrada.");
        }
        BancoDeDadosImp.bebidas.add(b);
    }

    @Override
    public void atualizar(Bebida b) {
        if (this.remover(b.id())) {
            this.salvar(b);
        }

    }

    @Override
    public Bebida consultar(Integer id) {
        return bebidas.stream()
                .filter((b) -> b.id().equals(id))
                .findFirst()
                .orElseThrow(() ->
                        new NoSuchElementException("Nenhuma bebida com esse ID foi encontrada")
                );
    }

    @Override
    public boolean remover(Integer id) {
        return bebidas.removeIf((bebida) -> bebida.id().equals(id));
    }

    @Override
    public List<Bebida> listar(Ordernar ordernarPor) {
        return BancoDeDadosImp.bebidas;
    }
}
