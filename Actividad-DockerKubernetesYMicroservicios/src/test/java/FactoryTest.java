import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

import org.example.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

public class FactoryTest {

    //Mock de EnemyFactory para simular la creacion de enemigos
    @Mock
    private EnemyFactory ejemploMockFactory;

    //Mock de TowerFactory para simular la creacion de torres
    @Mock
    private TowerFactory ejemploMockTowerFactory;

    //Mocks de tipos especificos de enemigos
    @Mock
    private BasicEnemy mockBasicEnemy;

    @Mock
    private BossEnemy mockBossEnemy;

    @Mock
    private FastEnemy mockFastEnemy;

    //Mocks de tipos especificos de torres
    @Mock
    private LaserTower mockLaserTower;

    @Mock
    private CannonTower mockCannonTower;

    @Mock
    private ArrowTower mockArrowTower;

    @BeforeEach
    public void setUp() {
        //Inicializa los mocks
        MockitoAnnotations.openMocks(this);

        //Configuro stubs para EnemyFactory para que devuelvan los mocks especificos de enemigos
        when(ejemploMockFactory.createBasicEnemy()).thenReturn(mockBasicEnemy);
        when(ejemploMockFactory.createBossEnemy()).thenReturn(mockBossEnemy);
        when(ejemploMockFactory.createFastEnemy()).thenReturn(mockFastEnemy);

        //Configuro stubs para TowerFactory para que devuelvan los mocks especificos de torres
        when(ejemploMockTowerFactory.createLaserTower()).thenReturn(mockLaserTower);
        when(ejemploMockTowerFactory.createArrowTower()).thenReturn(mockArrowTower);
        when(ejemploMockTowerFactory.createCannonTower()).thenReturn(mockCannonTower);
    }

    //Prueba para la creacion de un BasicEnemy
    @Test
    public void testCreateBasicEnemy() {
        Enemy basicEnemy = ejemploMockFactory.createBasicEnemy();
        assertNotNull(basicEnemy); //Verifico que el enemigo no sea nulo
        assertEquals(mockBasicEnemy, basicEnemy); //Verifico que el enemigo sea el mock esperado
        verify(ejemploMockFactory, times(1)).createBasicEnemy(); //Verifico que el metodo se llame una vez
    }

    //Prueba para la creacion de un BossEnemy
    @Test
    public void testCreateBossEnemy() {
        Enemy bossEnemy = ejemploMockFactory.createBossEnemy();
        assertNotNull(bossEnemy); //Verifico que el enemigo no sea nulo
        assertEquals(mockBossEnemy, bossEnemy); //Verifico que el enemigo sea el mock esperado
        verify(ejemploMockFactory, times(1)).createBossEnemy(); //Verifico que el metodo se llame una vez
    }

    //Prueba para la creacion de un FastEnemy
    @Test
    public void testCreateFastEnemy() {
        Enemy fastEnemy = ejemploMockFactory.createFastEnemy();
        assertNotNull(fastEnemy); //Verifico que el enemigo no sea nulo
        assertEquals(mockFastEnemy, fastEnemy); //Verifico que el enemigo sea el mock esperado
        verify(ejemploMockFactory, times(1)).createFastEnemy(); //Verifico que el metodo se llame una vez
    }

    //Prueba para la creacion de una LaserTower
    @Test
    public void testCreateLaserTower() {
        Tower laserTower = ejemploMockTowerFactory.createLaserTower();
        assertNotNull(laserTower); //Verifico que la torre no sea nula
        assertEquals(mockLaserTower, laserTower); //Verifico que la torre sea el mock esperado
        verify(ejemploMockTowerFactory, times(1)).createLaserTower(); //Verifico que el metodo se llame una vez
    }

    //Prueba para la creacion de una CannonTower
    @Test
    public void testCreateCannonTower() {
        Tower cannonTower = ejemploMockTowerFactory.createCannonTower();
        assertNotNull(cannonTower); //Verifico que la torre no sea nula
        assertEquals(mockCannonTower, cannonTower); //Verifico que la torre sea el mock esperado
        verify(ejemploMockTowerFactory, times(1)).createCannonTower(); //Verifico que el metodo se llame una vez
    }

    //Prueba para la creacion de una ArrowTower
    @Test
    public void testCreateArrowTower() {
        Tower arrowTower = ejemploMockTowerFactory.createArrowTower();
        assertNotNull(arrowTower); //Verifico que la torre no sea nula
        assertEquals(mockArrowTower, arrowTower); //Verifico que la torre sea el mock esperado
        verify(ejemploMockTowerFactory, times(1)).createArrowTower(); //Verifico que el metodo se llame una vez
    }
}
