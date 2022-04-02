package com.company;

import java.util.Scanner;

public class Jogo {
    private boolean temVencedor = false;
    private int rodadasParaVencer;
    Computador c = new Computador();
    Jogador j = new Jogador();

    public Jogo() {
    }

    public void setRodadasParaVencer(int rodadasParaVencer) {
        this.rodadasParaVencer = rodadasParaVencer;
    }

    public int getRodadasParaVencer() {
        return rodadasParaVencer;
    }

    public void iniciaJogo() {
        int rodadas;
        boolean positivo = false;
        Scanner scanner = new Scanner(System.in);
        String jogadaHumano = "";
        String jogadaComputador;
        boolean jogadaValida = false;

        System.out.println("Bem-vindo ao Pedra, Papel ou Tesoura");
        System.out.println("Digite seu nome");
        j.setNome(scanner.nextLine());
        System.out.println("Bem-vindo, " + j.getNome() + "! Defina o número de vitórias necessárias para ganhar o jogo");

        while (!positivo) {
            try { rodadas = Integer.parseInt(scanner.nextLine());
                if (rodadas > 0) {
                    setRodadasParaVencer(rodadas);
                    positivo = true;
                } else {
                    System.out.println("Digite um número maior do que zero");
                }

            } catch(Exception e){
                System.out.println("Digite um número");
            }
        }
        System.out.println("Ganha o jogo quem vencer " + getRodadasParaVencer() + " rodadas primeiro!");
        while (!this.temVencedor) {

            while (!jogadaValida) {
                System.out.println("Digite sua jogada (pedra/papel/tesoura)");
                jogadaHumano = scanner.nextLine();
                if (jogadaHumano.equals("pedra") || jogadaHumano.equals("papel") || jogadaHumano.equals("tesoura")) {
                    jogadaValida = true;
                    System.out.println("Você jogou " + jogadaHumano);
                } else {
                    System.out.println("Digite uma opção válida");
                }
            }
            jogadaValida = false;
            jogadaComputador = c.joga();
            System.out.println("O computador jogou " + jogadaComputador);
            verificaRodada(jogadaHumano,jogadaComputador);
            verificaVencedor();
        }

        scanner.close();
    }

    public void verificaRodada(String jogadaHumano, String jogadaComputador) {
        if (jogadaComputador.equals(jogadaHumano)) {
            System.out.println("Empatou");
        } else if (jogadaComputador.equals("papel") && jogadaHumano.equals("pedra") ||
                jogadaComputador.equals("pedra") && jogadaHumano.equals("tesoura") ||
                jogadaComputador.equals("tesoura") && jogadaHumano.equals("papel")) {

            System.out.println("Computador ganhou a rodada!");
            c.somaVitoria();
        } else {
            System.out.println("Você venceu a rodada!");
            j.somaVitoria();

        }
        System.out.println("--------------------");
        System.out.println("Placar:");
        System.out.println(j.getNome() + ": " + j.getVitorias());
        System.out.println("Computador: " + c.getVitorias());
        System.out.println("--------------------");
    }

    public void verificaVencedor() {
        if (c.getVitorias() == getRodadasParaVencer()) {
            System.out.println("Computador ganhou!");
            this.temVencedor = true;
        } else if (j.getVitorias() == getRodadasParaVencer()) {
            System.out.println("Você ganhou!");
            this.temVencedor = true;
        } else {
            System.out.println("Ainda não há vencedor!");
        }

    }

}


