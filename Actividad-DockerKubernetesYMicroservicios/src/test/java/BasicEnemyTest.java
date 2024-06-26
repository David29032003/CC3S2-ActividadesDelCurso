import org.example.BasicEnemy;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class BasicEnemyTest {

    @Test
    public void testAtaque() {
        //Configuro la captura de la salida del sistema
        ByteArrayOutputStream outputStreamCaptor = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStreamCaptor));
        //Creo instancia del BasicEnemy
        BasicEnemy basicEnemy = new BasicEnemy();
        //Llamo al metodo ataque
        basicEnemy.ataque();
        //Obtengo la salida capturada y normalizarla
        String expectedOutput = "BasicEnemy ataca con velocidad 1, salud 100, recompensa 10\n";
        //trim() para eliminar espacios en blanco al inicio y final
        String actualOutput = outputStreamCaptor.toString().trim();
        //Normalizo las cadenas antes de compararlas
        expectedOutput = expectedOutput.replaceAll("\\s+", " ").trim();
        actualOutput = actualOutput.replaceAll("\\s+", " ").trim();
        //Verifico que la salida esperada coincide con la salida obtenida
        assertEquals(expectedOutput, actualOutput);
        //Restauro la salida estándar del sistema
        System.setOut(System.out);
    }
}


