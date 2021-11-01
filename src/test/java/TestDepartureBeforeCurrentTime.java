import com.gridnine.testing.model.Flight;
import com.gridnine.testing.rule.implement.DepartureBeforeCurrentTime;
import com.gridnine.testing.rule.Rule;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;

import static com.gridnine.testing.util.FlightBuilder.createFlight;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class TestDepartureBeforeCurrentTime {

    @Test
    public void testDepartureBeforeCurrentTime() {
        Rule rule = new DepartureBeforeCurrentTime();
        List<Flight> caseList = getCaseList();

        assertTrue(rule.check(caseList.get(0)));
        assertFalse(rule.check(caseList.get(1)));
        assertTrue(rule.check(caseList.get(2)));
    }

    List<Flight> getCaseList() {
        List<Flight> caseList = Arrays.asList(
                createFlight(LocalDateTime.now().minusDays(3), LocalDateTime.now().minusDays(3).plusHours(2)),
                createFlight(LocalDateTime.now().plusDays(2), LocalDateTime.now().plusDays(2).plusHours(2)),
                createFlight(
                        LocalDateTime.now().plusHours(5), LocalDateTime.now().plusHours(6),
                        LocalDateTime.now().minusHours(1), LocalDateTime.now().plusHours(1)));
        return caseList;
    }
}
