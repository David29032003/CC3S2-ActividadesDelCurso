package ActividadMetricasDeCalidadDeSoftware.example.demo;

public class ContactoOperacionesModulo {
    public void enviarMensaje(String mensaje, Usuario usuario) {
        System.out.println("Enviando mensaje a " + usuario.getNombre() + ": " + mensaje);
    }
}
