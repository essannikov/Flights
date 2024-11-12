import com.gridnine.testing.model.Flight;
import com.gridnine.testing.model.FlightBuilder;
import com.gridnine.testing.service.FlightUtils;
import com.gridnine.testing.service.predicates.ArrivalBeforeDeparturePredicateImpl;
import com.gridnine.testing.service.predicates.DepartureBeforeNowPredicateImpl;
import com.gridnine.testing.service.predicates.TransferMoreThanTwoHoursPredicateImpl;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.function.Predicate;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class FlightUtilsTest {
    @Test
    void filterAll(){
        List<Flight> flightList = FlightBuilder.createFlights();

        List<Flight> expectedList = flightList.subList(0,2);

        List<Flight> actualList = FlightUtils.filter(flightList, new Predicate[]{
                new DepartureBeforeNowPredicateImpl().negate(),
                new ArrivalBeforeDeparturePredicateImpl().negate(),
                new TransferMoreThanTwoHoursPredicateImpl().negate()
        });

        assertEquals(expectedList, actualList);
    }
}
