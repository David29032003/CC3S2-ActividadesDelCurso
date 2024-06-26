package org.example;

public interface TranslationService {
    default String translate(String text, String sourceLang, String targetLang) {
        return text;
    }
}
