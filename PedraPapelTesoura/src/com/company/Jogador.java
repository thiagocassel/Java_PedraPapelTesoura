package com.company;

public class Jogador {
    private int vitorias;
    private String nome;

    public Jogador() {
        this.vitorias = 0;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getNome() {
        return nome;
    }

    public int getVitorias() {
        return vitorias;
    }

    public void somaVitoria() {
        this.vitorias += 1;
    }


}


