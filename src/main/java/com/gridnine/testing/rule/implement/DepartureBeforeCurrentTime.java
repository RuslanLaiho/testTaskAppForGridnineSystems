package com.gridnine.testing.rule.implement;

import com.gridnine.testing.model.Flight;
import com.gridnine.testing.model.Segment;
import com.gridnine.testing.rule.Rule;

import java.time.LocalDateTime;
import java.util.List;

public class DepartureBeforeCurrentTime implements Rule {

    @Override
    public boolean check(Flight flights) {
        List<Segment> segments = flights.getSegments();
        for (int i = 0; i < segments.size(); i++) {
            if (segments.get(i).getDepartureDate().isBefore(LocalDateTime.now()))
                return true;
        }
        return false;
    }
}
