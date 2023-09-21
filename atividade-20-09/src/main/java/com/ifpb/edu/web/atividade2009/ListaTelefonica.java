package com.ifpb.edu.web.atividade2009;

import java.util.ArrayList;
import java.util.List;

public class ListaTelefonica {
    private static List<Contato> contatos = new ArrayList<>();

    public static void cadastrarContato(String nome, String numero, String email) {
        var contato = new Contato(nome, email, numero);
        contatos.add(contato);
    }

    public static List<Contato> listarContatos() {
        return contatos;
    }
}
