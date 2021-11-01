import com.gridnine.testing.model.Flight;
import com.gridnine.testing.rule.implement.TotalTimeBetweenSegmentsIsMore2Hours;
import com.gridnine.testing.rule.Rule;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;

import static com.gridnine.testing.util.FlightBuilder.createFlight;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class TestTotalTimeBetweenSegmentsIsMore2Hours {
    @Test
    public void testTotalTimeBetweenSegmentsIsMore2Hours() {
        Rule rule = new TotalTimeBetweenSegmentsIsMore2Hours();
        List<Flight> caseList = getCaseList();

        assertFalse(rule.check(caseList.get(0)));
        assertTrue(rule.check(caseList.get(1)));
        assertTrue(rule.check(caseList.get(2)));
    }

    List<Flight> getCaseList() {
        List<Flight> caseList = Arrays.asList(
                createFlight(
                        LocalDateTime.now(), LocalDateTime.now().plusHours(2),
                        LocalDateTime.now().plusHours(3).plusMinutes(20), LocalDateTime.now().plusHours(4)),
                createFlight(
                        LocalDateTime.now(), LocalDateTime.now().plusHours(2),
                        LocalDateTime.now().plusDays(1).plusMinutes(20), LocalDateTime.now().plusDays(1).plusHours(4)),
                createFlight(
                        LocalDateTime.now(), LocalDateTime.now().plusHours(2),
                        LocalDateTime.now().plusHours(2).plusMinutes(30), LocalDateTime.now().plusHours(3),
                        LocalDateTime.now().plusHours(3).plusMinutes(40), LocalDateTime.now().plusHours(5),
                        LocalDateTime.now().plusHours(5).plusMinutes(60), LocalDateTime.now().plusHours(7)));
        return caseList;
    }
}
