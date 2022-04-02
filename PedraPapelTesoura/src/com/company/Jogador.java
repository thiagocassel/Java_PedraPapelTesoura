package com.company;

import java.util.Scanner;

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

    public String joga() {
        Scanner scanner = new Scanner(System.in);
        boolean jogadaValida = false;
        String jogadaHumano = "";

        while (!jogadaValida) {
            System.out.println("Digite sua jogada (pedra/papel/tesoura)");
            jogadaHumano = scanner.nextLine();
            if (jogadaHumano.equals("pedra") || jogadaHumano.equals("papel") || jogadaHumano.equals("tesoura")) {
                jogadaValida = true;
                System.out.println("Você jogou " + jogadaHumano);
                return  jogadaHumano;
            } else {
                System.out.println("Digite uma opção válida");
            }
        }
        return "";
    }

}


