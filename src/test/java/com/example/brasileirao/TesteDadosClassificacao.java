package com.example.brasileirao;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.util.*;

import org.junit.Test;
import org.junit.experimental.categories.Category;

@Category(Funcional.class)
public class TesteDadosClassificacao {

    @Test
    public void deveCriarUmaTabela(){

        // criando alguns times
        Time time1 = new Time("Palmeiras");
        Time time2 = new Time("Flamengo");
        Time time3 = new Time("Corinthians");

        List<Time> times = Arrays.asList(time1, time2, time3);

        // criando a tabela
        TabelaJogos tabela = new TabelaJogos(times);

        // verificando se a tabela contém a quantidade correta de times
        List<DadosClassificacao> classificacao = tabela.getTabelaClassificacao();

        assertNotNull(classificacao);
        assertEquals(3, classificacao.size());
        assertTrue(classificacao.stream().anyMatch(d -> d.getTime().equals(time1)));

    }

    @Test
    public void deveAtualizarClassificacaoCorretamenteAposUmaRodada() {
        // Arrange - cria os times
        Time palmeiras = new Time("Palmeiras");
        Time flamengo = new Time("Flamengo");
        Time corinthians = new Time("Corinthians");
        Time saoPaulo = new Time("São Paulo");

        // Cria uma rodada com duas partidas
        Rodada rodada = new Rodada(1);

        // Palmeiras vence o Flamengo
        Partida p1 = new Partida(palmeiras, flamengo, 2, 0);

        // Corinthians empata com São Paulo
        Partida p2 = new Partida(corinthians, saoPaulo, 1, 1);

        rodada.adicionaPartida(p1);
        rodada.adicionaPartida(p2);

        // Cria a tabela com os 4 times
        TabelaJogos tabela = new TabelaJogos(List.of(palmeiras, flamengo, corinthians, saoPaulo));

        // Act - aplica a rodada
        tabela.aplicarRodada(rodada);

        // Assert - obtém a tabela ordenada
        List<DadosClassificacao> classificacao = tabela.getTabelaClassificacao();

        // Esperado:
        // Palmeiras: 3 pontos
        // Corinthians: 1 ponto
        // São Paulo: 1 ponto
        // Flamengo: 0 ponto

        assertEquals("Palmeiras", classificacao.get(0).getTime().getNome());
        assertEquals(3, classificacao.get(0).getPontos());

        assertEquals(1, classificacao.get(1).getPontos());
        assertEquals(1, classificacao.get(2).getPontos());
        assertEquals(0, classificacao.get(3).getPontos());
    }

}