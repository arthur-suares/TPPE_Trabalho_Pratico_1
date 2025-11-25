package com.example.brasileirao;

import java.util.*;

public class TabelaJogos {
    
    private final Map<Time, DadosClassificacao> map = new HashMap<>();

    public TabelaJogos(Collection<Time> times)
    {
        if(times == null)
            throw new IllegalArgumentException("Times não podem ser nulos. Informe ao menos dois times!\n");

        for(Time t: times)
            map.put(t, new DadosClassificacao(t));
    }

    public void aplicarRodada(Rodada rodada)
    {
        for(Partida p: rodada.getPartidas())
        {
            DadosClassificacao time_da_casa = map.get(p.getTime_da_casa());
            DadosClassificacao time_visitante = map.get(p.getTime_visitante());

            if(time_da_casa == null || time_visitante == null)
                throw new IllegalArgumentException("Não foi possível identificar quais times estão na partida");

            Placar placar = p.getPlacar();

            time_da_casa.adicionarResultadoPartida(placar.getGols_da_casa(), placar.getGols_do_visitante());
            time_visitante.adicionarResultadoPartida(placar.getGols_do_visitante(), placar.getGols_da_casa());
        }
    }

    public List<DadosClassificacao> getTabelaClassificacao()
    {
        List<DadosClassificacao> dados_de_classificacao = new ArrayList<>(map.values());
        dados_de_classificacao.sort(null);
        return dados_de_classificacao;
    }
}
