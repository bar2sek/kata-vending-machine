import org.junit.Before;
import org.junit.Test;

import static junit.framework.TestCase.*;

public class AcceptCoinsTest {
    private VendingMachine machine;

    @Before
    public void setUp() {
        machine = new VendingMachine();
        machine.setCredit(0);
    }

    @Test
    public void machineAbleToIdentifyBadCoinsInserted() {

        String coinInserted = "asdfasfasdf";

        assertEquals("INSERT COIN\n", machine.acceptValidCoins(coinInserted));
    }

    @Test
    public void machineAbleToIdentifyGoodCoinsInserted() {

        String coinInserted = "dime";

        assertEquals("10", machine.acceptValidCoins(coinInserted));
    }

    @Test
    public void machineAbleToIdentifyAQuarterInserted() {

        String coinInserted = "quarter";

        assertEquals("25", machine.acceptValidCoins(coinInserted));
    }

    @Test
    public void addCreditsForMultipleCoinsInserted() {

        assertEquals("25", machine.getTotalCredit("quarter"));
        assertEquals("35", machine.getTotalCredit("dime"));
    }

//    @Test
//    public void machineReturnsBadCoinsToCoinReturn() {
//
//    }

}
