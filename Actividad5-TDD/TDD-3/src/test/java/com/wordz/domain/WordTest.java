package com.wordz.domain;

import org.junit.jupiter.api.Test;

import static com.wordz.domain.Letter.*;
import static org.assertj.core.api.Assertions.assertThat;

public class WordTest {
    @Test
    public void oneIncorrectLetter() {
        var word = new Word("A");
        var score = word.guess("B");
        assertThat(score.letter(0)).isEqualTo(INCORRECT);
    }
    @Test
    public void oneCorrectLetter() {
        //arrange
        var word = new Word("A");
        //act
        var score = word.guess("A");
        //assert
       assertScoreForLetter(score, 0, CORRECT);
    }

    private void assertScoreForLetter(Score score, int position, Letter expected) {
        assertThat(score.letter(position)).isEqualTo(expected);
    }

    @Test
    void secondLetterWrongPossition() {
        var word = new Word("AR");
        var score = word.guess("ZA");

            assertScoreForLetter(score,1, Letter.PART_CORRECT);
    }

    @Test
    void allScoreCombinations(){
        //arrange
        var word = new Word("ARI");
        //act
        var score = word.guess("ZAI");
        //assert
        assertScoreForGuess(score,INCORRECT, PART_CORRECT, CORRECT);
    }

    private void assertScoreForGuess(Score score, Letter...expectedScores) {
        for (int position=0; position<expectedScores.length; position++) {
            Letter expected = expectedScores[position];
            assertThat(score.letter(position)).isEqualTo(expected);
        }
    }

}
