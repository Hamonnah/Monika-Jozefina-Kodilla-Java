package com.kodilla.good.patterns.flight;

import java.util.ArrayList;

public class FlightsRetriever {

    public FlightsRetriever() {
    }

    public ArrayList<Flight> retrieve() {
        ArrayList<Flight> flights = new ArrayList<>();
        flights.add(new Flight("Oslo Torp", "Poznan"));
        flights.add(new Flight("Wroclaw", "Oslo Torp"));
        flights.add(new Flight("Warszawa", "Rzeszow"));
        flights.add(new Flight("Katowice", "Oslo Torp"));
        flights.add(new Flight("Warszawa", "Paris"));
        flights.add(new Flight("Paris", "Warszawa"));

        return flights;
    }

}
