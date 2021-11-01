package com.gridnine.testing;

import com.gridnine.testing.util.FlightBuilder;
import com.gridnine.testing.filter.FilterFlightProcessor;
import com.gridnine.testing.model.Flight;
import com.gridnine.testing.enumeration.RulesEnum;
import com.gridnine.testing.service.RulesMap;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Flight> flightList = FlightBuilder.createFlights();

        System.out.println("\nResult DEPARTURE_BEFORE_CURRENT_TIME filter: ");
        new FilterFlightProcessor(RulesMap.getRules(RulesEnum.DEPARTURE_BEFORE_CURRENT_TIME))
                .filter(flightList).forEach(flight -> System.out.println(flight));

        System.out.println("\nResult ARRIVAL_EARLIER_THAN_DEPARTURE filter: ");
        new FilterFlightProcessor(RulesMap.getRules(RulesEnum.ARRIVAL_EARLIER_THAN_DEPARTURE))
                .filter(flightList).forEach(flight -> System.out.println(flight));

        System.out.println("\nResult TOTAL_TIME_BETWEEN_SEGMENTS_IS_MORE_2_HOURS filter: ");
        new FilterFlightProcessor(RulesMap.getRules(RulesEnum.TOTAL_TIME_BETWEEN_SEGMENTS_IS_MORE_2_HOURS))
                .filter(flightList).forEach(flight -> System.out.println(flight));
    }
}
