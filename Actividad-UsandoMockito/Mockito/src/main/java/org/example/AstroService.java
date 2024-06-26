package org.example;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class AstroService {

    private final Gateway<AstroResponse> gateway;

    public AstroService(Gateway<AstroResponse> gateway) {
        this.gateway = gateway;
    }

    public Map<String, Long> getAstroData() {
        Map<String, Long> astroDataMap = new HashMap<>();

        // Obtain the AstroResponse from the Gateway
        AstroResponse response = gateway.getResponse();

        // Process the response to populate astroDataMap
        List<Assignment> people = response.getPeople();
        for (Assignment assignment : people) {
            String craft = assignment.getCraft();
            astroDataMap.put(craft, astroDataMap.getOrDefault(craft, 0L) + 1);
        }

        return astroDataMap;
    }

    // Método para filtrar astronautas por nave espacial
    public List<Assignment> filterAstronautsByCraft(String craftName) {
        // Obtain the AstroResponse from the Gateway
        AstroResponse response = gateway.getResponse();

        // Filter astronauts by craft name
        List<Assignment> filteredAstronauts = response.getPeople().stream()
                .filter(assignment -> assignment.getCraft().equals(craftName))
                .collect(Collectors.toList());

        return filteredAstronauts;
    }
}


