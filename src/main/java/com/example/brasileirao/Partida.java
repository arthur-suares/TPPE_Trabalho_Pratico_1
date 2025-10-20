package com.example.brasileirao;

public class Partida {
    private final Time time_da_casa;
    private final Time time_visitante;
    private final int gols_da_casa;
    private final int gols_do_visitante;

    public Partida(Time time_da_casa, Time time_visitante, int gols_da_casa, int gols_do_visitante) {

        if(time_da_casa == null || time_visitante == null){
            throw new IllegalArgumentException("Nenhum dos times pode ser nulo!\n");
        }
        if(time_visitante.equals(time_da_casa)){
            throw new IllegalArgumentException("Os times a jogarem não podem ser os mesmos!\n");
        }
        if(gols_da_casa < 0 || gols_do_visitante < 0){
            throw new IllegalArgumentException("Os gols não podem ser negativos!\n");
        }

        this.time_da_casa = time_da_casa;
        this.time_visitante = time_visitante;
        this.gols_da_casa = gols_da_casa;
        this.gols_do_visitante = gols_do_visitante;
    }
    
    public Time getTime_da_casa() {
        return time_da_casa;
    }
    public Time getTime_visitante() {
        return time_visitante;
    }
    public int getGols_da_casa() {
        return gols_da_casa;
    }
    public int getGols_do_visitante() {
        return gols_do_visitante;
    }

    public boolean jogo_empatado(){
        return gols_da_casa == gols_do_visitante;
    }

    @Override
    public String toString(){
        return String.format("%s %d  X  %d %s", time_da_casa, gols_da_casa, gols_do_visitante, time_visitante);
    }


    
    
}
