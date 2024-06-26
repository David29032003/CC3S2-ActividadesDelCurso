package org.example;

import java.util.ArrayList;
import java.util.List;

public class FakeGateway implements Gateway<AstroResponse> {
    @Override
    public AstroResponse getResponse() {
        List<Assignment> assignments = new ArrayList<>();
        assignments.add(new Assignment("Chris Cassidy", "ISS"));
        assignments.add(new Assignment("Anatoly Ivanishin", "ISS"));
        assignments.add(new Assignment("Ivan Vagner", "ISS"));
        assignments.add(new Assignment("Douglas Hurley", "Dragon"));
        assignments.add(new Assignment("Bob Behnken", "Dragon"));
        assignments.add(new Assignment("Chris Ferguson", "Dragon"));
        assignments.add(new Assignment("Bob Chapek", "SpaceX"));
        assignments.add(new Assignment("Gwynne Shotwell", "SpaceX"));
        assignments.add(new Assignment("Elon Musk", "SpaceX"));

        // Add duplicates
        assignments.add(new Assignment("Chris Cassidy", "ISS"));
        assignments.add(new Assignment("Bob Behnken", "Dragon"));
        assignments.add(new Assignment("Elon Musk", "SpaceX"));

        return new AstroResponse(assignments.size(), "Astronauts in space", assignments);
    }
}
