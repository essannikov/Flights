package com.gridnine.testing.model;

import java.time.LocalDateTime;

/**
 * Bean that represents a flight segment.
 */
public interface Segment {
    LocalDateTime getDepartureDate();
    LocalDateTime getArrivalDate();
}
