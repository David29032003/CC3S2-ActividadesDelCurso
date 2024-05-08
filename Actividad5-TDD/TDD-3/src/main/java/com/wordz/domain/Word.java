package com.wordz.domain;

public class Word {
    private final String word;

    public Word(String correctWord) {
        this.word = correctWord;
    }

    public Score guess(String attempt) {
        var score = new Score(word);

        score.assess( attempt);//evalua la primer letra de la palabra que va a ser adivinada
        return score;//retorna el puntaje

    }
}
