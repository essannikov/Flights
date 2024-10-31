package com.gridnine.testing.service;

import com.gridnine.testing.model.Flight;

import java.time.LocalDateTime;
import java.util.function.Predicate;

public class DepartureBeforeNowPredicateImpl implements Predicate<Flight> {
    @Override
    public boolean test(Flight flight) {
        return flight.getSegments().stream().anyMatch(
                segment -> segment.getDepartureDate().
                        isBefore(LocalDateTime.now()));
    }
}
