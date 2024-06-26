
import org.example.Enemy;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.mockito.Mockito.*;


public class EnemyTest {

    @Mock
    private Enemy ejemploMockEnemy; //Mock de ejemplo para la clase Enemy

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this); //Inicializo los mocks
        ejemploMockEnemy = mock(Enemy.class); //Creo el mock para Enemy
    }

    @Test
    public void testEnemyAtaque() {
        //Configuro el mock para no hacer nada cuando se llama a ataque()
        doNothing().when(ejemploMockEnemy).ataque();

        //Llamo al metodo ataque() en el mock
        ejemploMockEnemy.ataque();

        //Verifico que el metodo ataque() fue llamado exactamente una vez
        verify(ejemploMockEnemy, times(1)).ataque();
    }

    @Test
    public void testEnemyDerrota() {
        //Configuro el mock para devolver 10 cuando se llama a derrota()
        when(ejemploMockEnemy.derrota()).thenReturn(10);

        //Llamo al metodo derrota() y guarda el resultado en reward
        int reward = ejemploMockEnemy.derrota();

        //Verifico que el metodo derrota() fue llamado exactamente una vez
        verify(ejemploMockEnemy, times(1)).derrota();

        //Compruebo que la recompensa es igual a 10
        assert(reward == 10);
    }

    @Test
    public void testEnemyVida() {
        //Configuro el mock para devolver 100 cuando se llama a getHealth()
        when(ejemploMockEnemy.getHealth()).thenReturn(100);

        //Llamo al metodo getHealth() y guarda el resultado en health
        int health = ejemploMockEnemy.getHealth();

        //Verifico que el metodo getHealth() fue llamado exactamente una vez
        verify(ejemploMockEnemy, times(1)).getHealth();

        //Compruebo que la salud es igual a 100
        assert(health == 100);
    }
}

