package com.kodilla.exception.test;

import java.util.HashMap;

public class FlightFinder {

    public boolean findFlight(Flight flight) throws RouteNotFoundException {

        HashMap<String, Boolean> availableArivalAirport = new HashMap<>();
        availableArivalAirport.put("Warszawa Modlin", true);
        availableArivalAirport.put("Poznan", true);
        availableArivalAirport.put("Katowice Pyrzowice", true);
        availableArivalAirport.put("Oslo Torp", true);
        availableArivalAirport.put("Oslo Gardermoen", false);

        if(availableArivalAirport.containsKey(flight.getArrivalAirport())) {
            return availableArivalAirport.get(flight.getArrivalAirport());
        } else {
            throw new RouteNotFoundException("Route not found");
        }
    }

    public static void main(String[] args) {

        Flight flight = new Flight("Katowice Pyrzowice", "Oslo");
        FlightFinder flightFinder = new FlightFinder();

        try {
            if(flightFinder.findFlight(flight)) {
                System.out.println("Your flight to: " + flight.getArrivalAirport() + " is available. Have a nice fly!");
            } else {
                System.out.println("Your flight to: " + flight.getArrivalAirport() + " is unavailable.");
            }

        } catch(RouteNotFoundException e) {
            System.out.println(e.getMessage());
        }
    }

}
