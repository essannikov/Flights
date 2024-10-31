package com.gridnine.testing.service;

import com.gridnine.testing.model.Flight;
import com.gridnine.testing.model.Segment;

import java.time.Duration;
import java.util.List;
import java.util.function.Predicate;

public class TransferMoreThanTwoHoursPredicateImpl implements Predicate<Flight> {
    @Override
    public boolean test(Flight flight) {
        List<Segment> segments = flight.getSegments();
        Duration duration = Duration.ZERO;

        for (int i = 1; i < segments.size(); i++) {
            duration = duration.plus(Duration.between(
                    segments.get(i).getDepartureDate(),
                    segments.get(i - 1).getArrivalDate()).abs());
        }

        return duration.toHours() >= 2;
    }
}
