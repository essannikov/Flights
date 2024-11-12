package com.gridnine.testing.service;

import com.gridnine.testing.model.Flight;

import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public final class FlightUtils {
    private FlightUtils(){}

    public static List<Flight> filter(List<Flight> flightList, Predicate... filters) {
        return (List<Flight>) flightList.stream().
                    filter(combine(filters)).
                    collect(Collectors.toList());
    }

    public static Predicate combine(Predicate... filters) {
        return Arrays.stream(filters).
                    reduce(Predicate::and).
                    orElse(x -> true);
    }
}
