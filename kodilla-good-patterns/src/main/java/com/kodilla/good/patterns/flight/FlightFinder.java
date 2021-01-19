package com.kodilla.good.patterns.flight;

import java.util.ArrayList;
import java.util.List;

public class FlightResult {

    private final List<Flight> flights = new ArrayList<>();

    public FlightResult() {
        flights.add(new Flight("Wizzair", "1234D", "Oslo Torp", "Poznan"));
    }
}
