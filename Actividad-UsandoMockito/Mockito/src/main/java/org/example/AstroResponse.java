package org.example;

import java.util.ArrayList;
import java.util.List;

public class AstroResponse {
    private int number;
    private String message;
    private List<Assignment> people;

    public AstroResponse(int number, String message, List<Assignment> people) {
        this.number = number;
        this.message = message;
        this.people = people;
    }

    public int getNumber() {
        return number;
    }

    public String getMessage() {
        return message;
    }

    public List<Assignment> getPeople() {
        return people;
    }

    public void setNumber(int number){
        this.number = number;
    }

    public void setMessage(String message){
        this.message = message;
    }

    public void setPeople(List<Assignment> people){
        this.people = new ArrayList<>();
    }

    @Override
    public String toString() {
        return "AstroResponse{" +
                "number=" + number +
                ", message='" + message + '\'' +
                ", people=" + people +
                '}';
    }
}

