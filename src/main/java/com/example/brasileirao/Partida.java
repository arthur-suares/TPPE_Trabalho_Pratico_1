package com.example.brasileirao;

public class Partida {
    private final Time time_da_casa;
    private final Time time_visitante;
    private final Placar placar;

    public Partida(Time time_da_casa, Time time_visitante, Placar placar) {

        if(time_da_casa == null || time_visitante == null){
            throw new IllegalArgumentException("Nenhum dos times pode ser nulo!\n");
        }
        if(time_visitante.equals(time_da_casa)){
            throw new IllegalArgumentException("Os times a jogarem não podem ser os mesmos!\n");
        }

        this.time_da_casa = time_da_casa;
        this.time_visitante = time_visitante;
        this.placar = placar;
    }
    
    public Time getTime_da_casa() {
        return time_da_casa;
    }
    public Time getTime_visitante() {
        return time_visitante;
    }
    public Placar getPlacar() {
        return placar;
    }

    public boolean jogoEmpatado() {
        return placar.jogo_empatado();
    }

    @Override
    public String toString(){
        return String.format("%s %s %s", time_da_casa, placar, time_visitante);
    }
    
}
