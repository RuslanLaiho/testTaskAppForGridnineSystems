import com.gridnine.testing.enumeration.RulesEnum;
import com.gridnine.testing.filter.FilterFlightProcessor;
import com.gridnine.testing.model.Flight;
import com.gridnine.testing.service.RulesMap;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;


public class TestFilterFlightProcessor {
    @Test
    public void testFilterFlightProcessor() {
        TestDepartureBeforeCurrentTime testDepartureBeforeCurrentTime = new TestDepartureBeforeCurrentTime();
        List<Flight> caseList1 = testDepartureBeforeCurrentTime.getCaseList();
        List<Flight> caseList1AfterFilter = new FilterFlightProcessor(RulesMap.getRules(RulesEnum.DEPARTURE_BEFORE_CURRENT_TIME)).filter(caseList1);

        assertEquals(2, caseList1AfterFilter.size());
        assertTrue(caseList1.get(0).equals(caseList1AfterFilter.get(0)));
        assertTrue(caseList1.get(2).equals(caseList1AfterFilter.get(1)));

        TestArrivalEarlierThanDeparture testArrivalEarlierThanDeparture = new TestArrivalEarlierThanDeparture();
        List<Flight> caseList2 = testArrivalEarlierThanDeparture.getCaseList();
        List<Flight> caseList2AfterFilter = new FilterFlightProcessor(RulesMap.getRules(RulesEnum.ARRIVAL_EARLIER_THAN_DEPARTURE)).filter(caseList2);

        assertEquals(2, caseList2AfterFilter.size());
        assertTrue(caseList2.get(1).equals(caseList2AfterFilter.get(0)));
        assertTrue(caseList2.get(2).equals(caseList2AfterFilter.get(1)));

        TestTotalTimeBetweenSegmentsIsMore2Hours testTotalTimeBetweenSegmentsIsMore2Hours = new TestTotalTimeBetweenSegmentsIsMore2Hours();
        List<Flight> caseList3 = testTotalTimeBetweenSegmentsIsMore2Hours.getCaseList();
        List<Flight> caseList3AfterFilter = new FilterFlightProcessor(RulesMap.getRules(RulesEnum.TOTAL_TIME_BETWEEN_SEGMENTS_IS_MORE_2_HOURS)).filter(caseList3);

        assertEquals(2, caseList3AfterFilter.size());
        assertTrue(caseList3.get(1).equals(caseList3AfterFilter.get(0)));
        assertTrue(caseList3.get(2).equals(caseList3AfterFilter.get(1)));

    }
}



