package com.example.brasileirao;
import java.util.*;

public class Cronograma{
    public static List<Rodada> calculaIdaEVolta(List<Time> times){      
        int qtd = times.size();

        List<Rodada> rodadasGeradas = new ArrayList<>();
        int rodadasPorTurno = qtd-1;

        List<Time> timesEmRotacao = new ArrayList<>(times); 
        
        Time fixo = timesEmRotacao.remove(0);

        for(int i = 0; i < rodadasPorTurno; i++){
            Rodada rodada = new Rodada(i+1);

            for(int j = 0; j < (qtd/2); j++){
                Time time1, time2;
                int ajuste;

                if(j == 0){
                    time1 = fixo;
                } else {
                    time1 = timesEmRotacao.get(j - 1);
                }

                if(j == 0){
                    ajuste = 1;
                } else{
                    ajuste = 0;
                }

                time2 = timesEmRotacao.get((qtd-2 - (j-1) + ajuste) % (qtd-1));


                if(i%2 == 0){
                    rodada.adicionaPartida(new Partida(time1, time2, 0, 0));
                } else{
                    rodada.adicionaPartida(new Partida(time2, time1, 0, 0));
                }
            }

            rodadasGeradas.add(rodada);
            timesEmRotacao.add(0, timesEmRotacao.remove(timesEmRotacao.size() - 1));
        }

        int numAtualRodadas = rodadasPorTurno;

        int tmp = 0;
        while(tmp < rodadasPorTurno){
            Rodada anterior = rodadasGeradas.get(tmp);
            Rodada rodada = new Rodada(numAtualRodadas+1);

            List<Partida> partidasAnteriores = anterior.getPartidas();
            
            int i = 0;
            while (i < partidasAnteriores.size()) {
                Partida p = partidasAnteriores.get(i);
                rodada.adicionaPartida(new Partida(p.getTime_visitante(), p.getTime_da_casa(), 0, 0));
                i++;
            }

            rodadasGeradas.add(rodada);
            numAtualRodadas++;
            tmp++;
        }


        assert rodadasGeradas.size() == 2*rodadasPorTurno : "Número de rodadas incorreto";
        return rodadasGeradas;
    }
}