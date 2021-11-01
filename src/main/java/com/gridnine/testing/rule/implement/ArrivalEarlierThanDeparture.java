package com.gridnine.testing.rule.implement;

import com.gridnine.testing.model.Flight;
import com.gridnine.testing.model.Segment;
import com.gridnine.testing.rule.Rule;

import java.util.List;

public class ArrivalEarlierThanDeparture implements Rule {

    @Override
    public boolean check(Flight flights) {
        List<Segment> segments = flights.getSegments();
        for (Segment segment : segments) {
            if (segment.getDepartureDate().isAfter(segment.getArrivalDate()))
                return true;
        }
        return false;
    }
}
