package com.gridnine.testing.rule.implement;

import com.gridnine.testing.model.Flight;
import com.gridnine.testing.model.Segment;
import com.gridnine.testing.rule.Rule;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.List;

public class TotalTimeBetweenSegmentsIsMore2Hours implements Rule {

    @Override
    public boolean check(Flight flights) {
        List<Segment> segments = flights.getSegments();
        if (segments.size() >= 2) {
            long totalMin = 0L;
            for (int i = 0; i < segments.size() - 1; i++) {
                LocalDateTime startTime = segments.get(i).getArrivalDate();
                LocalDateTime endTime = segments.get(i + 1).getDepartureDate();
                long minutesBetween = ChronoUnit.MINUTES.between(startTime, endTime);
                totalMin = totalMin + minutesBetween;
            }
            if (totalMin > 120)
                return true;
            else
                return false;
        }
        return false;
    }
}
