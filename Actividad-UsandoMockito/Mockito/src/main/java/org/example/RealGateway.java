package org.example;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Scanner;

public class RealGateway implements Gateway<AstroResponse> {

    @Override
    public AstroResponse getResponse() {
        try {
            // URL de la API que devuelve la lista de astronautas en el espacio
            URL url = new URL("http://api.open-notify.org/astros.json");
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("GET");

            // Verificamos que la respuesta sea exitosa (código 200)
            if (conn.getResponseCode() != 200) {
                throw new RuntimeException("Failed : HTTP error code : " + conn.getResponseCode());
            }

            // Procesamos la respuesta JSON utilizando un Scanner
            Scanner scanner = new Scanner(url.openStream());
            StringBuilder jsonContent = new StringBuilder();
            while (scanner.hasNext()) {
                jsonContent.append(scanner.nextLine());
            }
            scanner.close();

            // Cerramos la conexión
            conn.disconnect();

            // Convertimos la respuesta JSON en un objeto AstroResponse
            // En este ejemplo, parseamos manualmente para simplificar
            // En un escenario real, utilizarías una biblioteca JSON como Jackson, Gson, etc.
            String jsonResponse = jsonContent.toString();
            int number = parseNumber(jsonResponse);
            String message = "Success"; // Suponiendo un mensaje fijo para simplificar
            AstroResponse response = new AstroResponse(number, message, null); // La lista de personas queda como null aquí
            return response;

        } catch (IOException e) {
            e.printStackTrace(); // Manejo básico de errores, lo ideal sería lanzar una excepción personalizada
            return null;
        }
    }

    // Método para parsear el número de astronautas desde la respuesta JSON
    private int parseNumber(String jsonResponse) {
        // En este ejemplo simplificado, extraemos el número directamente de la respuesta JSON
        // En un escenario real, parsearías la respuesta JSON correctamente
        // Suponemos que la respuesta tiene un campo "number"
        return Integer.parseInt(jsonResponse.substring(jsonResponse.indexOf("number") + 8, jsonResponse.indexOf("number") + 9));
    }
}

