package com.example.brasileirao;

import java.util.List;

import org.junit.Test;
import org.junit.experimental.categories.Category;

@Category(Excecao.class)
public class TesteTimeInexistenteNaTabela {
    //Teste para caso o time não exista na tabela
    @Test(expected = IllegalArgumentException.class)
    public void deveLancarExcecaoSePartidaTemTimeNaoInexistenteNaTabela(){
        Time time1 = new Time("Botafogo");
        Time time2 = new Time("Juventude");
        Time time3 = new Time("Vasco");
        TabelaJogos tabela = new TabelaJogos(List.of(time1, time2)); //A tabela só tem Botafogo e Juventude

        Rodada rodada = new Rodada(1);
        rodada.adicionaPartida(new Partida(time1, time3, 0, 0)); //Mas a partida tem Botafogo e Vasco

        tabela.aplicarRodada(rodada);
    }

}
