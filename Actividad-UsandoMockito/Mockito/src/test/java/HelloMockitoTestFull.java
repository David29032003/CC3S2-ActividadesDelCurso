
import org.example.HelloMockito;
import org.example.Person;
import org.example.PersonRepository;
import org.example.TranslationService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDate;
import java.time.Month;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class HelloMockitoTestFull {
    @Mock
    private PersonRepository repository;
    @Mock
    private TranslationService translationService;
    @InjectMocks
    private HelloMockito helloMockito;

    @Test
    @DisplayName("Greet multiple people")
    void greetMultiplePeople() {
        // Set up mock responses
        when(repository.findById(1))
                .thenReturn(Optional.of(new Person(1, "Grace", "Hopper",
                        LocalDate.of(1906, Month.DECEMBER, 9))));
        when(repository.findById(2))
                .thenReturn(Optional.of(new Person(2, "Ada", "Lovelace",
                        LocalDate.of(1815, Month.DECEMBER, 10))));
        when(repository.findById(3))
                .thenReturn(Optional.empty()); // Simulating person not found

        when(translationService.translate("Hello, Grace, from Mockito!", "en", "en"))
                .thenReturn("Hello, Grace, from Mockito!");
        when(translationService.translate("Hello, Ada, from Mockito!", "en", "en"))
                .thenReturn("Hello, Ada, from Mockito!");

        // Call the greetMultiple method
        List<String> greetings = helloMockito.greetMultiple(Arrays.asList(1, 2, 3), "en", "en");

        // Verify the results using AssertJ assertions
        assertThat(greetings).containsExactly("Hello, Grace, from Mockito!",
                "Hello, Ada, from Mockito!", "Error: Unable to find person with id 3");
    }
}

