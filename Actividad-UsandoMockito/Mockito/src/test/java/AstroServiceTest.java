
import org.example.Assignment;
import org.example.AstroService;
import org.example.FakeGateway;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class AstroServiceTest {

    private AstroService service;

    @BeforeEach
    void setUp() {
        // Create an instance of AstroService using FakeGateway
        service = new AstroService(new FakeGateway());
    }

    @Test
    void testFilterAstronautsByCraft() {
        // Call the method under test
        List<Assignment> astronautsOnRocinante = service.filterAstronautsByCraft("Rocinante");

        // Assert the results
        assertThat(astronautsOnRocinante).hasSize(2); // Expecting 2 astronauts on Rocinante
        assertThat(astronautsOnRocinante.get(0).getName()).isEqualTo("Alex");
        assertThat(astronautsOnRocinante.get(1).getName()).isEqualTo("Naomi");
    }
}




