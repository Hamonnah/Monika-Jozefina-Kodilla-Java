package com.kodilla.good.patterns.flight;

import java.util.HashMap;
import java.util.List;

public class FlightSearchingApplication {

    public static void main(String[] args) {
        FlightsRetriever currentFlightsList = new FlightsRetriever();

        FlightFinder flightSearch = new FlightFinder();

        String selectedAirport = "Warszawa";
        System.out.println("\nList of flights departing from: " + selectedAirport);

        flightSearch.departureAirportSearch(currentFlightsList.retrieve(), selectedAirport).stream()
                .map(n -> n.getArrivalAirport())
                .sorted()
                .forEach(System.out::println);

        selectedAirport = "Oslo Torp";
        System.out.println("\nList of flights arriving to: " + selectedAirport);

        flightSearch.arrivalAirportSearch(currentFlightsList.retrieve(), selectedAirport).stream()
                .map(n -> n.getDepartureAirport())
                .sorted()
                .forEach(System.out::println);

        String selectedDepartingAirport = "Wroclaw";
        String selectedArrivalAirport = "Katowice";

        List<Flight> directFlights = flightSearch.directFlightSearch(currentFlightsList.retrieve(), selectedDepartingAirport, selectedArrivalAirport);

        System.out.println("\n" + directFlights.size() + " direct flights found on route [ " + selectedDepartingAirport + " -> " + selectedArrivalAirport + " ]");
        directFlights.stream()
                .map(n -> n.getArrivalAirport()
                        + n.getDepartureAirport())
                .sorted()
                .forEach(System.out::println);

        selectedDepartingAirport = "Katowice";
        selectedArrivalAirport = "Oslo Torp";

        HashMap<Flight, Flight> connections = flightSearch.connectionFlightSearch(currentFlightsList.retrieve(), selectedDepartingAirport, selectedArrivalAirport);
        System.out.println("\n" + connections.size() + " connections found on route [ " + selectedDepartingAirport + " -> via -> " + selectedArrivalAirport + " ]");
    }

}
