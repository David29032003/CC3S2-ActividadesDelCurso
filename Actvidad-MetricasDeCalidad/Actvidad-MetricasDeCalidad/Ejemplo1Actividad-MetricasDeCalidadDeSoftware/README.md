# Actividad de Metricas de calidad de software

En esta actividad calcularemos las metricas de calidad de software para algunos ejemplos de sistemas en java con una cierta cantidad de modulos.

## Ejemplo de un sistema en Java con tres modulos
Supongamos que estamos construyendo un sistema de manejo de contactos, que incluye modulos para usuarios, grupos de contactos y operaciones de contacto. Mostramos una representacion muy simplificada:

## Modulo UsuarioModulo

```java
import java.util.ArrayList;
import java.util.List;

public class UsuarioModulo {
    private List<Usuario> usuarios = new ArrayList<>();

    //Dependencia a la clase Usuario
    public void agregarUsuario(Usuario usuario) {
        usuarios.add(usuario);

        //Dependencia a la clase GrupoContactoModulo
        GrupoContactoModulo.agregarUsuarioAGrupo(usuario, "General");
    }

    //Dependencia a la clase Usuario
    public void eliminarUsuario(String nombre) {
        usuarios.removeIf(u -> u.getNombre().equals(nombre));
    }
}
```

`UsuarioModulo` es una clase que gestiona una lista de usuarios, permitiendo agregar y eliminar usuarios. Tambien se integra con el modulo `GrupoContactoModulo` para añadir usuarios a un grupo por defecto llamado "General".

### Dependencias

### Clase `Usuario`:
- Se usa para crear una lista de objetos `Usuario`.
- Se pasa como parametro en los métodos `agregarUsuario` y `eliminarUsuario`.
- Se llama al metodo `getNombre` del objeto `Usuario` en el metodo `eliminarUsuario`.

### Clase `GrupoContactoModulo`:
- Se llama al metodo estatico `agregarUsuarioAGrupo` en el metodo `agregarUsuario`.

## Clase Usuario
La clase `UsuarioModulo` utiliza la clase `Usuario` para crear una lista de objetos `Usuario` y gestionar su inserción y eliminación.

```java
package ActividadMetricasDeCalidadDeSoftware.example.demo;

public class Usuario {
    private String nombre;
    
    public Usuario(String nombre) {
        this.nombre = nombre;
    }
    
    public String getNombre() {
        return nombre;
    }
}
```
- la clase `Usuario` no presenta dependencias explicitas.

## Modulo SistemaContactos

`SistemaContactos` es la clase principal que actua como punto de entrada para la aplicacion. Maneja la creacion de usuarios, el envio de mensajes, y la gestion de grupos de contacto.

```java
public class SistemaContactos {
    public static void main(String[] args) {
        UsuarioModulo usuarioModulo = new UsuarioModulo();
        Usuario nuevoUsuario = new Usuario("Juan");
        usuarioModulo.agregarUsuario(nuevoUsuario);
        ContactoOperacionesModulo operacionesModulo = new ContactoOperacionesModulo();
        operacionesModulo.enviarMensaje("¡Hola!", nuevoUsuario);
        GrupoContactoModulo.crearGrupo("Amigos");
        GrupoContactoModulo.agregarUsuarioAGrupo(nuevoUsuario, "Amigos");
    }
}
```

### Dependencias

### Clase `UsuarioModulo`:
- Se instancia para manejar operaciones relacionadas con usuarios.
- Se utiliza el metodo `agregarUsuario` de `UsuarioModulo`.

### Clase `Usuario`:
- Se instancia un objeto `Usuario` para representar un nuevo usuario llamado "Juan".
- Se pasa como parametro en los metodos `agregarUsuario` y `enviarMensaje`.

### Clase `ContactoOperacionesModulo`:
- Se instancia para manejar operaciones de contacto.
- Se utiliza el metodo `enviarMensaje` de `ContactoOperacionesModulo`.

### Clase `GrupoContactoModulo`:
- Se llama a los metodos estaticos `crearGrupo` y `agregarUsuarioAGrupo` de `GrupoContactoModulo`.

## Modulo GrupoContactoModulo

`GrupoContactoModulo` es una clase que gestiona grupos de contactos, permitiendo la creacion de grupos y la adicion de usuarios a estos grupos.

```java
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GrupoContactoModulo {
    static Map<String, List<Usuario>> grupos = new HashMap<>();
    
    static {
        grupos.put("General", new ArrayList<>());
    }
    
    public static void agregarUsuarioAGrupo(Usuario usuario, String grupoNombre) {
        grupos.get(grupoNombre).add(usuario);
    }
    
    public static void crearGrupo(String nombre) {
        if (!grupos.containsKey(nombre)) {
            grupos.put(nombre, new ArrayList<>());
        }
    }
}
```

### Dependencias

### Clase `Usuario`:
- Los objetos `Usuario` se agregan a las listas dentro del mapa `grupos`.
- Se pasa como parámetro en el método `agregarUsuarioAGrupo`.


## Modulo ContactoOperacionesModulo

`ContactoOperacionesModulo` es una clase que maneja operaciones de contacto, especificamente el envio de mensajes a usuarios.

```java
public class ContactoOperacionesModulo {
    public void enviarMensaje(String mensaje, Usuario usuario) {
        System.out.println("Enviando mensaje a " + usuario.getNombre() + ": " + mensaje);
    }
}
```

### Dependencias

### Clase `Usuario`:
- Se utiliza para obtener informacion del usuario al que se le envia un mensaje.
- Se pasa como parametro en el metodo `enviarMensaje`.

## Diagrama para observar las dependencias de las clases

![Descripción de la imagen](Imagenes/Acoplamiento.png)

## Calculo del Factor de acoplamiento (CF)

- Para calcular el CF utilizaremos la ecuacion: CF = e/a*(n-1)
- Donde e es el numero total de conexiones de acoplamiento reales entre modulos, a es el numero de modulos en el sistema y n es el numero total de modulos
- Observando el diagrama de dependencias tenemos que e es 8, a es 5 y n es 5.
- Entonces en la ecuacion CF = 8/5(5-1) = 0.4
- Teniendo como resultado que el CF es 0.4

