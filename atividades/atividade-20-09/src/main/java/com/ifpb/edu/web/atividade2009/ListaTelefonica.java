package com.ifpb.edu.web.atividade2009;

import java.util.ArrayList;
import java.util.List;

public class ListaTelefonica {
    private static final List<Contato> contatos = new ArrayList<>();

    static {
        contatos.add(new Contato("Arthur", null, "(83)99999-9999"));
    }

    public static boolean removerContato(Integer id) {
        return contatos.removeIf((contato -> contato.getId().equals(id)));
    }

    public static void cadastrarContato(String nome, String numero, String email) {
        var contato = new Contato(nome, email, numero);
        contatos.add(contato);
    }

    public static List<Contato> listarContatos() {
        return contatos;
    }
}
