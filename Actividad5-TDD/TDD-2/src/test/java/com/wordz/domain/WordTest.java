package com.wordz.domain;

import org.junit.jupiter.api.Test;

import static com.wordz.domain.Letter.*;
import static org.assertj.core.api.Assertions.assertThat;

public class WordTest {
    //No implementado
    @Test
    public void oneIncorrectLetter(){
        var word = new Word("A");
        var Score = word.guess("Z");// guess == adivinar
    }

    public void guess(String z){
        //no accion
    }

    public void guess(String attempt){
        var score = new Score();
        return score;
    }
}
