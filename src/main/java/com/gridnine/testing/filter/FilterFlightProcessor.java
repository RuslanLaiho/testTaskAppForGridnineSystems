package com.gridnine.testing.filter;

import com.gridnine.testing.model.Flight;
import com.gridnine.testing.rule.Rule;

import java.util.List;
import java.util.stream.Collectors;

public class FilterFlightProcessor {
    private List<Rule> rules;

    public List<Flight> filter(List<Flight> flights) {
        List<Flight> flightsAfterFilter = flights.stream()
                .filter(flight -> check(flight))
                .collect(Collectors.toList());
        return flightsAfterFilter;
    }

    boolean check(Flight flight) {
        for (Rule rule : rules) {
            if (!rule.check(flight))
                return false;
        }
        return true;
    }

    public FilterFlightProcessor(List<Rule> rules) {
        this.rules = rules;
    }
}
