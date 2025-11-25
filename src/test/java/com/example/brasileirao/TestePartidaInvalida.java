package com.example.brasileirao;

import org.junit.Test;
import org.junit.experimental.categories.Category;

@Category(Excecao.class)
public class TestePartidaInvalida {
    //Teste para time da casa nulo
    @Test(expected = IllegalArgumentException.class)
    public void deveLancarExcecaoSeTimeDaCasaNulo(){
        new Partida(null, new Time("time2"), new Placar(0, 0));
    }

    //Teste para times iguais na partida
    @Test(expected = IllegalArgumentException.class)
    public void deveLancarExcecaoSeTimesSaoIguais(){
        Time time = new Time("timeLegal");
        new Partida(time, time, new Placar(0, 0));
    }

    //Teste para gols negativos
    @Test(expected = IllegalArgumentException.class)
    public void deveLancarExcecaoSeGolsDaCasaNegativo(){
        new Partida(new Time("time1"), new Time("time2"), new Placar(-1, 0));
    }

}
