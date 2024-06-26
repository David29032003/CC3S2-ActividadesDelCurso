package org.example;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class HelloMockito {
    private String greeting = "Hello, %s, from Mockito!";
    // Dependencies
    private PersonRepository personRepository;
    private TranslationService translationService;

    // Constructor to inject the dependencies
    public HelloMockito(PersonRepository personRepository, TranslationService translationService) {
        this.personRepository = personRepository;
        this.translationService = translationService;
    }

    // Method to greet a single person
    public String greet(int id, String sourceLang, String targetLang) {
        try {
            Optional<Person> person = personRepository.findById(id);
            String name = (String) person.map(Person::getFirst).orElse("World");
            return translationService.translate(String.format(greeting, name), sourceLang, targetLang);
        } catch (Exception ex) {
            return "Error: Unable to greet person";
        }
    }

    // Method to greet multiple people
    public List<String> greetMultiple(List<Integer> ids, String sourceLang, String targetLang) {
        List<String> greetings = new ArrayList<>();
        for (int id : ids) {
            try {
                Optional<Person> person = personRepository.findById(id);
                if (person.isPresent()) {
                    String name = (String) person.get().getFirst();
                    greetings.add(translationService.translate(String.format(greeting, name), sourceLang, targetLang));
                } else {
                    greetings.add("Error: Unable to find person with id " + id);
                }
            } catch (Exception ex) {
                greetings.add("Error: Unable to greet person with id " + id);
            }
        }
        return greetings;
    }
}

