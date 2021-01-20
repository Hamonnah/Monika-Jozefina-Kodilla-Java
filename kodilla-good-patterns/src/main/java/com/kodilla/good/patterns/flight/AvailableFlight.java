package com.kodilla.good.patterns.flight;

import java.util.HashMap;
import java.util.Map;

public class AvailableFlight {

    public static Map<Integer, Flight> getAvailableFlightMap() {
        Map<Integer, Flight> availableFlightMap = new HashMap<>();
        availableFlightMap.put(0,new Flight("Oslo Torp", "", "Poznan"));
        availableFlightMap.put(1,new Flight("Wroclaw", "Warsaw", "Rzeszow"));
        availableFlightMap.put(2,new Flight("Warszawa Modlin", "Krakow", "Rzeszow"));
        availableFlightMap.put(3,new Flight("Katowice", "", "Oslo Torp"));
        availableFlightMap.put(4,new Flight("Warszawa", "Gdansk", "Paris"));
        availableFlightMap.put(5,new Flight("Paris", "", "Warszawa"));

        return availableFlightMap;
    }

}
