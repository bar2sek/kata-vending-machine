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

        assertEquals("10", machine.acceptValidCoins("dime"));
    }

    @Test
    public void machineAbleToIdentifyAQuarterInserted() {

        assertEquals("25", machine.acceptValidCoins("quarter"));
    }

    @Test
    public void addCreditsForMultipleCoinsInserted() {

        assertEquals("25", machine.acceptValidCoins("quarter"));
        assertEquals("35", machine.acceptValidCoins("dime"));
    }

    @Test
    public void getTotalCreditsReceived() {

        machine.acceptValidCoins("quarter");
        machine.acceptValidCoins("dime");
        machine.acceptValidCoins("nickel");

        assertEquals("40", machine.getTotalCredit());
    }

}
