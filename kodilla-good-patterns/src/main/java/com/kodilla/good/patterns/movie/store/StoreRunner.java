package com.kodilla.good.patterns.movie.store;

import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class StoreRunner {

    public static void main(String[] args) {

        MovieStore movieStore = new MovieStore();
        Map<String, List<String>> moviesMap = movieStore.getMovies();

        String movies = moviesMap.values().stream()
                .flatMap(Collection::stream)
                .collect(Collectors.joining("!"));

        System.out.println(movies + "!");
    }

}
