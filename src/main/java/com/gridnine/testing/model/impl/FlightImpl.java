package com.gridnine.testing.model.impl;

import com.gridnine.testing.model.Flight;
import com.gridnine.testing.model.Segment;

import java.util.List;
import java.util.stream.Collectors;

public class FlightImpl implements Flight {
    private final List<Segment> segments;

    public FlightImpl(final List<Segment> segs) {
        segments = segs;
    }

    public List<Segment> getSegments() {
        return segments;
    }

    @Override
    public String toString() {
        return segments.stream().map(Object::toString)
                .collect(Collectors.joining(" "));
    }
}
