# ActividadRGR+TDD

## Organizacion de la actividad
Descargo el proyecto Java que de encontraba en el repositorio del curso para posteriormente abrir el directorio "Actividad6-RGR+TDR"

## Entendiendo la Actividad
Las pruebas unitarias nos permiten explorar y tomar decisiones de diseño sobre el código, manteniendolo libre de defectos y facil de mantener, El enfoque TDD nos proporciona ritmos que guian todo el ciclo de desarrollo, ayudandonos a saber qua hacer en cada paso. El primer ritmo, visto en la ultima actividad, consiste en escribir las secciones Arrange, Act y Assert en cada prueba. Luego, seguimos el ciclo de refactorización rojo-verde (RGR), que nos ayuda a diseñar un codigo limpio y facil de entender, listo para integrarse en la aplicacion mas amplia. Aplicaremos cada fase del ciclo RGR a la aplicación Wordz. Puedes encontrar más detalles en este enlace: [Actividades-CC3S2](https://github.com/kapumota/Actividades-CC3S2/tree/main/2024-1/Actividad5-TDD/TDD-3).

## Efectuamos la actividad
Trabaje en base a este ritmo de trabajo 

![Untitled](images/Untitled.png)

• Escribe una prueba que falle (ROJO).
• Haz que el código funcione (VERDE).
• Elimina la redundancia (REFACTORIZA/BLUE)

## El problema  :

- Vamos a jugar un poco al fútbol, ¿de acuerdo? Implementaremos una clase FootballTeam, para que
podamos comparar diferentes equipos y ver quién ocupa el primer lugar en la liga. Cada equipo lleva
un registro del número de juegos ganados.

## **1°Ciclo : Asegurar la funcionalidad del constructor para un valor**

**ROJO - Escribimos una prueba que falle**

Para poder comparar dos equipos, cada uno de ellos debe recordar su número de victorias. Por simplicidad, diseñemos una clase FootballTeam(SUT) que tome el número de juegos como parámetro del constructor. Lo primero es lo primero: asegurémonos de que este constructor funcione.

Comenzamos creando una nueva clase - **`FootballTeamTest`** - en algún lugar del directorio `src/test/java`. Puede lucir de la siguiente manera:

![Untitled](images/A.png)

Ejecutamos la prueba y efectivamente, la prueba fallo :

![Untitled](images/Untitled%202.png)

Con ayuda del IDE creamos la clase `FootballTeam`  su constructor y el metodo **`getGamesWon()`** , el minimo codigo para que la prueba pase (verde).

![Untitled](images/Untitled%203.png)

![Untitled](images/Untitled%204.png)

Dado que la prueba se compila, y tiene una aserción que verifica una funcionalidad importante perteneciente a nuestra clase, vale la pena ejecutarla. Una vez que la ejecutamos, falla!. .

![Untitled](images/Untitled%205.png)

Si alguna vez rompemos nuestro código SUT(FoorballTeam), de modo que esta prueba falle, el mensaje de aserción nos dirá precisamente qué está mal y la solución debería ser fácil.

![Untitled](images/Untitled%207.png)

**VERDE - Arregla el Código**

Modificamos el metodo **`getGameWon`** para que retorne 3 como resultado.

![Untitled](images/Untitled%208.png)

![Untitled](images/Untitled%209.png)

La prueba ha pasado , sin embargo eso no es suficiente.Antes de escribir más pruebas, hay otra fase de la que ocuparnos: **refactorización**.

**Refactorizacion- Aunque solo sea un poco(BLUE)**

Lo mínimo que deberíamos hacer es deshacernos del número mágico 3 - por ejemplo, introduciendo una variable **`THREE_GAMES_WON`**.

![Untitled](images/CAP5.png)

El cambio fue trivial, y no hay forma de que pudiera romper la prueba.

## 2° Ciclo : Asegurar la funcionalidad del constructor para mas de un valor

**ROJO :** 

Creamos una prueba para que el constructor acepte mas valores .Empecemos!!

![Untitled](images/Untitled%2011.png)

![Untitled](images/Untitled%2012.png)

**VERDE :** 

La prueba anterior falló , ahora hagamos que la prueba pase con el mínimo codigo posible(VERDE) :

![Untitled](images/Untitled%2013.png)

Ejecutamos nuevamente la prueba , esta pasó (verde):

![Untitled](images/Untitled%2014.png)

**REFACTORIZAR (BLUE)**

Nuestra prueba puede limpiarse: ya que  no hay necesidad de que el primer método de prueba esté allí. El segundo test cubre el escenario de 3 juegos ganados, y también hace mucho más. 

Por ello eliminamos la primera prueba

![Untitled](images/CAP6.png)

Ejecutamos de nuevo la suit de pruebas ,sigue verde !

![Untitled](images/Untitled%2016.png)

## 3° Ciclo Asegurar que el constructor no acepte valores negativos

**ROJO**: 

Basándonos en nuestra experiencia anterior, podemos comenzar con una prueba parametrizada ya.

![Untitled](images/Untitled%2017.png)

La prueba falla esto se debe a que el constructor de la clase **`FootballTeam`** actualmente acepta cualquier valor: 

![Untitled](images/Untitled%2018.png)

**VERDE** : 

Solucionemos el problema anterior , para que la prueba pasa .Para ello modifiquemos la clase **`FootballTeam`** : 

![Untitled](images/Untitled%2019.png)

![Untitled](images/Untitled%2020.png)

La prueba paso correctamente .

## 4° CICLO : Comparar los puntajes de los equipos de futbol

El constructor funciona bien. Ahora podemos pasar al problema principal: es decir, comparar equipos de fútbol. En primer lugar, hemos decidido que vamos a usar la interfaz `**java.lang.Comparable**.`

ROJO: 

Para ello creemos una prueba para este comportamiento , veamos : 

![Untitled](images/Untitled%2021.png)

![Untitled](images/Untitled%2022.png)

VERDE : 

Debido a que la prueba fallo, modificaremos la clase **`FootballTeam`** implementado la interfaz Comparable:

![Untitled](images/Untitled%2023.png)

Ejecutamos nuevamente la prueba y esta pasa : 

![Untitled](images/Untitled%2024.png)

## 5°Ciclo : Pruebas de comparación de teams de futboll

 

Escribiremos la primera prueba de comparación. La idea es simple: tomar dos equipos con diferentes números de victorias y compararlos.

![Untitled](images/Untitled%2025.png)

La prueba deberia fallar ,efectivamente …

![Untitled](images/Untitled%2026.png)

VERDE : 

Para que la prueba pase , modifcamos el metodo **`compareTo`** de la clase **`FootballTeam`** : 

![Untitled](images/Untitled%2027.png)

![Untitled](images/Untitled%2028.png)

La prueba paso .

Ahora ejecutemos todas las pruebas para ver que no hayan ocurrido errores.

![Untitled](images/Untitled%2029.png)

No hubo algún error , las pruebas pasaron correctamente. 

**REFACTORIZAR (BLUE):**

Vamos a refactorizar el codigo, en la metodo **`compareTo`** podemos renombrar la variable o  por “otherteam”

![Untitled](images/Untitled%2030.png)

Ejecutamos nuevamente las pruebas para evitar nuevos errores: 

![Untitled](images/Untitled%2031.png)

Las pruebas pasaron exitosamente.

## 6°Ciclo : Prueba de igualdad de puntaje de los Teams de futbol

![Untitled](images/Untitled%2032.png)

Bueno, esta prueba pasa de inmediato, porque nuestra implementación ya ha devuelto 0 en casos de igualdad. Entonces, ¿qué deberíamos hacer ahora? Definitivamente hemos omitido un paso en el ritmo TDD.Nunca hemos visto esta prueba de igualdad fallar, así que no sabemos por qué pasa. ¿Por qué?

En nuestro caso, el cambio a introducir sería devolver algún otro valor que no sea 0 en la última línea del método **`compareTo() ,`** por ejemplo:

ROJO : 

![Untitled](images/Untitled%2033.png)

Así que la prueba está roja ahora. Después de revertir la línea para devolver 0 podemos ver que
todas nuestras pruebas pasan. Bien, nuestra prueba de igualdad está haciendo lo que debe!

![Untitled](images/Untitled%2034.png)

**VERDE** 

![Untitled](images/Untitled%2035.png)

![Untitled](images/Untitled%2036.png)

La prueba paso!

**BLUE** 

Avancemos a la refactorización. Ahora que tenemos una red de seguridad de pruebas, podemos realmente refactorizar el método que está siendo probado. Después de pensar cuidadosamente en
el asunto, hemos terminado con una implementación mucho más simple.

![Untitled](images/Untitled%2037.png)

Las pruebas no se vieron afectadas por la refactorizacion(todas pasaron) :

![Untitled](images/Untitled%2038.png)

Nota: 

Volver a ejecutar las pruebas ahora nos dice que esta implementación satisface todos los requisitos
(escritos en forma de pruebas) hasta ahora.