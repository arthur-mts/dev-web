package com.ifpb.dev.web.atividade7.entidades;

public record Bebida(
        String nome,
        Integer id,
        Double teorAlcoolico,
        Tipo tipo
) {
    private static int ID_COUNTER = 0;

    public Bebida() {
        this(null, null, null, null);
    }

    public Bebida(String nome, Double teorAlcoolico, Tipo tipo) {
        this(nome, ID_COUNTER++, teorAlcoolico, tipo);
    }
}
