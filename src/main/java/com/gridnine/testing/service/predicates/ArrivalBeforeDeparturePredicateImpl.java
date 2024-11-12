package com.gridnine.testing.service.predicates;

import com.gridnine.testing.model.Flight;
import java.util.function.Predicate;

public class ArrivalBeforeDeparturePredicateImpl implements Predicate<Flight> {
    @Override
    public boolean test(Flight flight) {
        return flight.getSegments().stream().anyMatch(
                segment -> segment.getArrivalDate().
                        isBefore(segment.getDepartureDate()));
    }
}
