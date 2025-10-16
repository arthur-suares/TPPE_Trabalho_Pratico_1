package com.example.brasileirao;

import java.util.Objects;

public class Time {
   
    private final String nome;

    //Construtor da classe
    public Time(String nome)
    {
        if(nome == null || nome.isBlank())
        {
            throw new IllegalArgumentException("Informe um nome para criar um time!\n");
        }

        this.nome = nome;
    }

    public String getNome()
    {
        return nome;
    }

    //Função pra verificar se dois times são iguais
    @Override
    public boolean equals(Object time_de_analise) 
    {
        
        if (this == time_de_analise)
        {
            return true;
        }
        
        if (!(time_de_analise instanceof Time))
        {
            return false;
        }

        Time time = (Time) time_de_analise;
        return nome.equals(time.nome);
    }

    @Override
    public int hashCode() 
    {
        return Objects.hash(nome);
    }

    @Override
    public String toString() 
    {
        return nome;
    }
}
