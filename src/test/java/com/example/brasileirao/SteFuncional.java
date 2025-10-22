package com.example.brasileirao;

import org.junit.experimental.categories.Categories;
import org.junit.experimental.categories.Categories.IncludeCategory;
import org.junit.runner.RunWith;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Categories.class)
@SuiteClasses({TesteCronograma.class, TesteDadosClassificacao.class})
@IncludeCategory(Funcional.class)
public class SteFuncional {
    
}
