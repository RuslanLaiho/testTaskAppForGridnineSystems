import com.gridnine.testing.model.Flight;
import com.gridnine.testing.rule.implement.ArrivalEarlierThanDeparture;
import com.gridnine.testing.rule.Rule;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;

import static com.gridnine.testing.util.FlightBuilder.createFlight;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class TestArrivalEarlierThanDeparture {
    @Test
    public void testArrivalEarlierThanDeparture() {
        Rule rule = new ArrivalEarlierThanDeparture();
        List<Flight> caseList = getCaseList();

        assertFalse(rule.check(caseList.get(0)));
        assertTrue(rule.check(caseList.get(1)));
        assertTrue(rule.check(caseList.get(2)));
    }

    List<Flight> getCaseList() {
        List<Flight> caseList = Arrays.asList(
                createFlight(LocalDateTime.now(), LocalDateTime.now().plusHours(2)),
                createFlight(LocalDateTime.now(), LocalDateTime.now().minusHours(5)),
                createFlight(
                        LocalDateTime.now().plusHours(5), LocalDateTime.now().plusHours(6),
                        LocalDateTime.now().plusHours(8), LocalDateTime.now().plusHours(10),
                        LocalDateTime.now().plusHours(14), LocalDateTime.now().plusHours(12)));
        return caseList;
    }
}
