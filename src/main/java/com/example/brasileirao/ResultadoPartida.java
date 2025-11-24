package com.example.brasileirao;

public class ResultadoPartida {
    private final DadosClassificacao _dadosClassificacao;
    private int golsMarcados;
    private int golsSofridos;


    public ResultadoPartida(
            DadosClassificacao _dadosClassificacao, 
            int golsMarcados, int golsSofridos) {
        this._dadosClassificacao = _dadosClassificacao;
        this.golsMarcados = golsMarcados;
        this.golsSofridos = golsSofridos;
    }

    void computePontos(){

        if(golsMarcados < 0 || golsSofridos < 0)
            throw new IllegalArgumentException("Não podem ser informados valores negativos!\n");
        
        this.golsMarcados += golsMarcados;
        this.golsSofridos += golsSofridos;

        computeVitorias();
        computeEmpates();
        computeGols();

    }

    void computeVitorias(){
        if(this.golsSofridos < this.golsMarcados)
        {
            _dadosClassificacao.adicionarVitoria();
            _dadosClassificacao.adicionarPontos(3);
        }
    }

    void computeEmpates(){
        if(golsMarcados == golsSofridos)
        {
            _dadosClassificacao.adicionarPontos(1);
        }

    }
    void computeGols(){
        _dadosClassificacao.adicionarGolsMarcados(this.golsMarcados);
        _dadosClassificacao.adicionarGolsSofridos(this.golsSofridos);
    }
}