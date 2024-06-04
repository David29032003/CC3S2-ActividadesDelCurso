package org.example;

import static org.assertj.core.api.Assertions.assertThat;
import org.junit.jupiter.api.Test;

public class CountWordsTest2 {
    @Test
    void testCountWordsEndingWithS() {
        int words = new CountWords().count("dogs cats");
        assertThat(words).isEqualTo(2);
    }

    @Test
    void testCountWordsEndingWithR() {
        int words = new CountWords().count("car bar");
        assertThat(words).isEqualTo(2);
    }

    @Test
    void testCountNoWordsEndingWithSOrR() {
        int words = new CountWords().count("dog cat");
        assertThat(words).isEqualTo(0);
    }

    @Test
    void testCountWordsWithSpecialCharacters() {
        int words = new CountWords().count("dog's car!");
        assertThat(words).isEqualTo(2);
    }

    @Test
    void testEmptyString() {
        int words = new CountWords().count("");
        assertThat(words).isEqualTo(0);
    }

    @Test
    void testCountSingleCharacterS() {
        int words = new CountWords().count("s");
        assertThat(words).isEqualTo(1);
    }

    @Test
    void testCountSingleCharacterR() {
        int words = new CountWords().count("r");
        assertThat(words).isEqualTo(1);
    }

    @Test
    void testCountSingleCharacterNonLetter() {
        int words = new CountWords().count("1");
        assertThat(words).isEqualTo(0);
    }

    @Test
    void testCountWordsEndingWithRAndS() {
        int words = new CountWords().count("runners dogs cars");
        assertThat(words).isEqualTo(3);
    }

    @Test
    void testCountWordsEndingWithNeither() {
        int words = new CountWords().count("hello world");
        assertThat(words).isEqualTo(0);
    }

    @Test void testCountWordsEndingWithSAndSpecialChar() {
        int words = new CountWords().count("dogs cats@");
        assertThat(words).isEqualTo(2);
    }

    @Test
    void testCountWordsStartingWithNonLetter() {
        int words = new CountWords().count("1dogs 2cats");
        assertThat(words).isEqualTo(2);
    }

    @Test
    void testCountWordsWithSpaces() {
        int words = new CountWords().count("dogs  cats");
        assertThat(words).isEqualTo(2);
    }
}
