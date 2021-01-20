package com.kodilla.good.patterns.flight;

public class FlightSearchingApplication {

    public static void main(String[] args) {
        String departureAirport = "Warszawa";
        String intermediateAirport = "Gdansk";
        String arrivalAirport = "Rzeszow";

        FlightFinder flightFinder = new FlightFinder();

        flightFinder.findFlightFromAirport(departureAirport, AvailableFlight.getAvailableFlightMap());
        flightFinder.findFlightWithIntermediateAirport(intermediateAirport, AvailableFlight.getAvailableFlightMap());
        flightFinder.findFlightToAirport(arrivalAirport, AvailableFlight.getAvailableFlightMap());
    }

}
