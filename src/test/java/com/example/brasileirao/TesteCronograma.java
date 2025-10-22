package com.example.brasileirao;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.*;

import org.junit.Test;
import org.junit.experimental.categories.Category;

@Category(Funcional.class)
public class TesteCronograma {

    // 1.Criar um time
    @Test
    public void deveCriarTimeComNome() {
        Time time = new Time("Flamengo");
        assertEquals("Flamengo", time.getNome());
    }

    // 2. Criar uma partida
    @Test
    public void deveCriarPartidaComTimeCasaEFora() {
        Time time_da_casa = new Time("Flamengo");
        Time time_de_fora = new Time("Palmeiras");
        Partida partida = new Partida(time_da_casa, time_de_fora, 2, 1);

        assertEquals(time_da_casa, partida.getTime_da_casa());
        assertEquals(time_de_fora, partida.getTime_visitante());
    }

    // 3. Criar uma rodada
    @Test
    public void deveCriarRodada() {
        Rodada rodada = new Rodada(1);
        Partida partida = new Partida(new Time("A"), new Time("B"), 2, 1);
        rodada.adicionaPartida(partida);

        assertEquals(1, rodada.getPartidas().size());
        assertTrue(rodada.getPartidas().contains(partida));
    }

    // 5. 2 times gera 1 rodada com 1 partida
    @Test
    public void deveGerarUmaRodadaParaDoisTimes() {
        List<Time> times = Arrays.asList(new Time("A"), new Time("B"));
        List<Rodada> rodadas = Cronograma.calculaIdaEVolta(times);

        assertEquals(2, rodadas.size()); // turno e returno
        assertEquals(1, rodadas.get(0).getPartidas().size());
    }

    @Test
    public void deveGerar38RodadasPara20TimesSemDuplicatas() {
        List<Time> times = new ArrayList<>();
        for (int i = 1; i <= 20; i++) {
            times.add(new Time("Time" + i));
        }

        List<Rodada> rodadas = Cronograma.calculaIdaEVolta(times);
        assertEquals(38, rodadas.size());

        Set<String> jogosVistos = new HashSet<>();
        for (Rodada rodada : rodadas) {
            assertEquals(10, rodada.getPartidas().size());
            for (Partida partida : rodada.getPartidas()) {
                String chave = partida.getTime_da_casa().getNome() + "->" + partida.getTime_visitante().getNome();
                assertFalse(jogosVistos.contains(chave));
                jogosVistos.add(chave);
            }
        }

        Map<String, Integer> paresSemOrdem = new HashMap<>();
        for (String chave : jogosVistos) {
            String[] partes = chave.split("->");
            String timeA = partes[0];
            String timeB = partes[1];
            String parNaoOrdenado = timeA.compareTo(timeB) < 0 ? timeA + "#" + timeB : timeB + "#" + timeA;
            paresSemOrdem.put(parNaoOrdenado, paresSemOrdem.getOrDefault(parNaoOrdenado, 0) + 1);
        }

        for (int quantidade : paresSemOrdem.values()) {
            assertEquals(2, quantidade);
        }
    }
}