package org.example;

import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;

class CountWordsTest {

    @Test
    void twoWordsEndingWithS() {
        int words = new CountWords().count("dogs cats");
        assertThat(words).isEqualTo(2);
    }

    @Test
    void noWordsAtAll() {
        int words = new CountWords().count("dog cat");
        assertThat(words).isEqualTo(0);
    }

    @Test
    void wordsThatEndInR() {
        int words = new CountWords().count("car bar");
        assertThat(words).isEqualTo(2);
    }

    @Test
    void wordsEndingWithSEndingWithR() {
        int words = new CountWords().count("cats bar dogs");
        assertThat(words).isEqualTo(3);
    }

    @Test
    void wordsWithSpecialCharacters() {
        int words = new CountWords().count("dogs, cats! car# bar?");
        assertThat(words).isEqualTo(4);
    }

    @Test
    void emptyString() {
        int words = new CountWords().count("");
        assertThat(words).isEqualTo(0);
    }

    @Test
    void onlySpecialCharactersAndNumbers() {
        int words = new CountWords().count("123 456! @#$$%");
        assertThat(words).isEqualTo(0);
    }

    @Test
    void singleWordEndingWithS() {
        int words = new CountWords().count("dogs");
        assertThat(words).isEqualTo(1);
    }

    @Test
    void singleWordEndingWithR() {
        int words = new CountWords().count("car");
        assertThat(words).isEqualTo(1);
    }

    @Test
    void wordsWithMixedCase() {
        int words = new CountWords().count("Dogs Cats Car Bar");
        assertThat(words).isEqualTo(4);
    }

    @Test
    public void testCountWordsEndingWithRorS() {
        CountWords counter = new CountWords();

        assertThat(counter.count("car bus")).isEqualTo(2); // 'car' y 'bus'
        assertThat(counter.count("hello world")).isEqualTo(0); // 'world'
        assertThat(counter.count("java programming")).isEqualTo(0); // ninguna palabra termina en 'r' o 's'
        assertThat(counter.count("This is a test.")).isEqualTo(2); // 'This', 'is' y 'test.'
        assertThat(counter.count("")).isEqualTo(0); // cadena vacía
        assertThat(counter.count("stars and mars")).isEqualTo(2); // 'stars' y 'mars'
        assertThat(counter.count("Mr. Rogers.")).isEqualTo(2); // 'Rogers'
        assertThat(counter.count("Super star")).isEqualTo(2); // 'star'
        assertThat(counter.count("Mr.")).isEqualTo(1); // 'Mr.'
        assertThat(counter.count("Hello!")).isEqualTo(0); // ninguna palabra termina en 'r' o 's'
    }
}
