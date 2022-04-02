package com.company;

import java.util.Random;

public class Computador {
    private String[] jogada = {"pedra", "papel", "tesoura"};
    private int vitorias;

    public Computador() {
        this.vitorias = 0;
    }

    public int getVitorias() {
        return vitorias;
    }

    public void somaVitoria() {
        this.vitorias += 1;
    }

    public String joga() {
        int a;
        Random aleatorio = new Random();
        a = aleatorio.nextInt(2);
        return this.jogada[a];
    }

}


