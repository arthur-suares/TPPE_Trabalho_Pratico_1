package com.example.brasileirao;

public class DadosClassificacao implements Comparable<DadosClassificacao>{
    private final Time time;
    private int golsMarcados = 0;
    private int golsSofridos = 0;
    private int pontos = 0;
    private int vitorias = 0;
    
    //construtor
    public DadosClassificacao(Time time){
        this.time = time;
    }

    //gets para os atributos
    public Time getTime(){
        return time;
    }

    public int getgolsMarcados(){
        return golsMarcados;
    }

    public int getgolsSofridos(){
        return golsSofridos;
    }

    public int getPontos(){
        return pontos;
    }

    public int getVitorias(){
        return vitorias;
    }

    //método para alterar valores dos atributos
    void adicionarGolsMarcados(int valor) {
        this.golsMarcados += valor;
    }

    void adicionarGolsSofridos(int valor) {
        this.golsSofridos += valor;
    }

    void adicionarVitoria() {
        this.vitorias++;
    }

    void adicionarPontos(int valor) {
        this.pontos += valor;
    }


    //método para calcular o resultado de uma partida
    public void calculaResultadoPartida(int golsM, int golsS){
        if(golsS == golsM){
            pontos = pontos+1;
            
        }
        else if(golsS < golsM){
            pontos = pontos+3;
            vitorias = vitorias+1;
        }

        golsMarcados = golsMarcados+golsM;
        golsSofridos = golsSofridos+golsS;
    }

    
    //calcula saldo de gols
    public int saldoDeGols(){
        return golsMarcados-golsSofridos;
    }

    //método que compara dois resultados (ou seja, dois objetos tipo DadosClassificacao)
    //na ordem correta para a classificação
    @Override
    public int compareTo(DadosClassificacao rival){
        if(this.pontos != rival.pontos){
            int comparaPontos = Integer.compare(rival.pontos, this.pontos);
            return comparaPontos;
        }

        if(this.vitorias != rival.vitorias){
            int comparaVitorias = Integer.compare(rival.vitorias, this.vitorias);
            return comparaVitorias;
        }

        if(this.saldoDeGols() != rival.saldoDeGols()){
            int comparaSaldoGols = Integer.compare(rival.saldoDeGols(), this.saldoDeGols());
            return comparaSaldoGols;
        }

        if(this.golsMarcados != rival.golsMarcados){
            int comparagolsMarcados = Integer.compare(rival.golsMarcados, this.golsMarcados);
            return comparagolsMarcados;
        }

        String nomeTimeAtual = this.time.getNome();
        String nomeTimeRival = rival.time.getNome();

        return nomeTimeAtual.compareTo(nomeTimeRival);
    }

    //método que retorna uma string com os dados da classificação na ordem
    @Override
    public String toString(){
        return new StringBuilder()
            .append(time)
            .append(" pontos=").append(pontos)
            .append(" vitorias=").append(vitorias)
            .append(" saldo de gols=").append(saldoDeGols())
            .append(" gols marcados=").append(golsMarcados)
            .toString();
    }

    public void adicionarResultadoPartida(int golsMarcados, int golsSofridos)
    {
        ResultadoPartida resultadoPartida = new ResultadoPartida(this, golsMarcados, golsSofridos);
        resultadoPartida.computePontos();

    }
}