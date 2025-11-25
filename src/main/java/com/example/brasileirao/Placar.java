package com.example.brasileirao;

public class Placar {
    private final int gols_da_casa;
    private final int gols_do_visitante;

    public Placar(int gols_da_casa, int gols_do_visitante) {

        if(gols_da_casa < 0 || gols_do_visitante < 0){
            throw new IllegalArgumentException("Os gols não podem ser negativos!\n");
        }

        this.gols_da_casa = gols_da_casa;
        this.gols_do_visitante = gols_do_visitante;
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
         return gols_da_casa + " X " + gols_do_visitante;
    }
    
}
