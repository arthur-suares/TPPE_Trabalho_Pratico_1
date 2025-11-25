package com.example.brasileirao;
import java.util.*;

public class Cronograma{
    //refatorando o método calculaIdaEVolta para tornar mais legível
   public static List<Rodada> calculaIdaEVolta(List<Time> times){    
        //cria dois métodos auxiliares e deixa a funcao principal mais simples  
        List<Rodada> ida = gerarTurno(times);
        List<Rodada> volta = gerarReturno(ida);

        List<Rodada> rodadasGeradas = new ArrayList<>();
        rodadasGeradas.addAll(ida);
        rodadasGeradas.addAll(volta);

        int rodadasPorTurno = times.size() - 1;
        assert rodadasGeradas.size() == 2*rodadasPorTurno : "Número de rodadas incorreto";
        return rodadasGeradas;
    }


    private static List<Rodada> gerarTurno(List<Time> times) {
        int qtd = times.size();

        List<Rodada> rodadasGeradas = new ArrayList<>();
        int rodadasPorTurno = qtd - 1;

        List<Time> timesEmRotacao = new ArrayList<>(times);

        Time fixo = timesEmRotacao.remove(0);

        for (int i = 0; i < rodadasPorTurno; i++) {
            Rodada rodada = new Rodada(i + 1);

            for (int j = 0; j < (qtd / 2); j++) {
                Time time1, time2;
                int ajuste;

                if (j == 0) {
                    time1 = fixo;
                } else {
                    time1 = timesEmRotacao.get(j - 1);
                }

                if (j == 0) {
                    ajuste = 1;
                } else {
                    ajuste = 0;
                }

                time2 = timesEmRotacao.get((qtd - 2 - (j - 1) + ajuste) % (qtd - 1));

                if (i % 2 == 0) {
                    rodada.adicionaPartida(new Partida(time1, time2, new Placar(0, 0)));
                } else {
                    rodada.adicionaPartida(new Partida(time1, time2, new Placar(0, 0)));
                }
            }

            rodadasGeradas.add(rodada);
            timesEmRotacao.add(0, timesEmRotacao.remove(timesEmRotacao.size() - 1));
        }

        return rodadasGeradas;
    }

     private static List<Rodada> gerarReturno(List<Rodada> ida) {
        List<Rodada> retorno = new ArrayList<>();
        int numAtualRodadas = ida.size();

        for (int idx = 0; idx < ida.size(); idx++) {
            Rodada anterior = ida.get(idx);
            Rodada rodada = new Rodada(numAtualRodadas + 1 + idx);

            List<Partida> partidasAnteriores = anterior.getPartidas();
            for (Partida p : partidasAnteriores) {
                rodada.adicionaPartida(new Partida(p.getTime_visitante(), p.getTime_da_casa(), new Placar(0, 0)));
            }

            retorno.add(rodada);
        }

        return retorno;
    }
}