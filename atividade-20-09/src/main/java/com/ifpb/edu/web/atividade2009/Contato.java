package com.ifpb.edu.web.atividade2009;

public class Contato {
    private static Integer incrementador_id = 0;
    private Integer id;
    private String nome;
    private String email;
    private String numero;

    public Contato(String nome, String email, String numero) {
        setNome(nome);
        setEmail(email);
        setNumero(numero);
        setId();
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public Integer getId() {
        return id;
    }

    private void setId() {
        this.id = incrementador_id++;
    }
}
