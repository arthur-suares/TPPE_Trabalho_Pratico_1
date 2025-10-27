package com.example.brasileirao;

import org.junit.Test;
import org.junit.experimental.categories.Category;

@Category(Excecao.class)
public class TesteTimeNomeInvalido {
    // Teste para nome nulo
    @Test(expected = IllegalArgumentException.class)
    public void deveLancarExcecaoSeNomeNulo(){
        new Time(null);
    }

    //Teste para nome vazio
    @Test(expected = IllegalArgumentException.class)
    public void deveLancarExcecaoSeNomeVazio(){
        new Time("");
    }

    //Teste para nome em branco
    @Test(expected = IllegalArgumentException.class)
    public void deveLancarExcecaoSeNomeEmBranco(){
        new Time(" ");
    }

}
