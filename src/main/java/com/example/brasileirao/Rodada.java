package com.example.brasileirao;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Rodada {
    private final int numero;
    private final List<Partida> partidas = new ArrayList<>(); //lista de partidas da rodada ex: (fla, flu, 3, 2)
    
    public Rodada(int numero) { //numero da rodada
        this.numero = numero;
    }

    public int getNumero() {
        return numero;
    }

    public void adicionaPartida(Partida p) {
        partidas.add(p);
    }

    public List<Partida> getPartidas() {
        return Collections.unmodifiableList(partidas);
    }
}